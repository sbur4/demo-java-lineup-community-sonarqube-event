package com.lineup.java.demo.core.service;

import com.lineup.java.demo.data.entity.User;
import com.lineup.java.demo.data.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    // trans
    // multi
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
