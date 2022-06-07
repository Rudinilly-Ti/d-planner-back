package com.example.dplanner.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dplanner.domain.entityes.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
