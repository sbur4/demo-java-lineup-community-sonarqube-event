package com.lineup.java.demo.data.repository;

import com.lineup.java.demo.data.entity.User;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    @QueryHints({
            @QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true"),
            @QueryHint(name = HibernateHints.HINT_CACHE_REGION, value = "user-queries"),
            @QueryHint(name = HibernateHints.HINT_FETCH_SIZE, value = "50")
    })
    Optional<User> findByEmail(@Param("email") String email);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(@QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "false"))
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findByIdForUpdate(@Param("id") String id);
}
