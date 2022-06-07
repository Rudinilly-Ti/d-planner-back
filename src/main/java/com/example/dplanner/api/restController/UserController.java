package com.example.dplanner.api.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dplanner.domain.entityes.User;
import com.example.dplanner.domain.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return service.create(user);
    }

    @PostMapping("/search")
    public User searchUser(@RequestBody String email) {
        return service.searchUser(email);
    }
}
