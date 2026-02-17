package com.lineup.java.demo.core.service.impl;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.ResponseUserDto;
import com.lineup.java.demo.core.dto.UpdateUserDto;
import com.lineup.java.demo.core.exception.UserExistException;
import com.lineup.java.demo.core.exception.UserNotFoundException;
import com.lineup.java.demo.core.mapper.UserMapper;
import com.lineup.java.demo.core.service.UserService;
import com.lineup.java.demo.data.entity.User;
import com.lineup.java.demo.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Argon2PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<ResponseUserDto> findAllUsers() {
        log.debug("Fetching all users from repository");
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public ResponseUserDto findUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(userNotFound("id", id));
    }

    @Override
    public ResponseUserDto findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(userNotFound("email", email));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE,
            rollbackFor = Exception.class
    )
    public ResponseUserDto createUser(CreateUserDto dto) {
        log.info("Attempting to create user with email: '{}'", dto.getUsername());

        userRepository.findByEmail(dto.getUsername()).ifPresent(u -> {
            throw new UserExistException("User with email already exists: " + u.getEmail());
        });

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getRawPassword()));

        User savedUser = userRepository.save(user);
        log.info("Successfully created user with ID: '{}'", savedUser.getId());
        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional
    public ResponseUserDto fullUpdateUserById(UpdateUserDto dto) {
        log.info("Performing full update for user email: {}", dto.getUsername());
        return updateWorkflow(dto, true);
    }

    @Override
    @Transactional
    public ResponseUserDto partialUpdateUserById(UpdateUserDto dto) {
        log.info("Performing partial update for user email: {}", dto.getUsername());
        return updateWorkflow(dto, false);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteUserById(String id) {
        if (!userRepository.existsById(id)) {
            throw userNotFound("id", id).get();
        }
        userRepository.deleteById(id);
        log.warn("Deleted user with ID: {}", id);
    }

    // REVIEW: should be approved
    private ResponseUserDto updateWorkflow(UpdateUserDto dto, boolean isFullUpdate) {
        User existingUser = userRepository.findByIdForUpdate(dto.getUsername())
                .orElseThrow(userNotFound("email", dto.getUsername()));

        userMapper.updateEntityFromDto(dto, existingUser);

        Optional.ofNullable(dto.getRawPassword())
                .filter(pass -> !pass.isBlank())
                .ifPresent(pass -> existingUser.setPassword(passwordEncoder.encode(pass)));

        return userMapper.toDto(userRepository.save(existingUser));
    }

    private Supplier<UserNotFoundException> userNotFound(String field, String value) {
        return () -> {
            String msg = String.format("User not found with %s: [%s]", field, value);
            log.error(msg);
            return new UserNotFoundException(msg);
        };
    }
}
