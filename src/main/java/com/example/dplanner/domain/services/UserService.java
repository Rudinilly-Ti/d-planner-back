package com.example.dplanner.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dplanner.domain.entityes.User;
import com.example.dplanner.domain.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

}
