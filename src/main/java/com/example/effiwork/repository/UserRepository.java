package com.example.effiwork.repository;

import com.example.effiwork.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}