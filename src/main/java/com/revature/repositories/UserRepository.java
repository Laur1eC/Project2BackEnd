package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    Optional<User> findByEmailAndPassword(String email, String password);
}
