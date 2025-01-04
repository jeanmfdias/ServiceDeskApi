package com.servicedesk.api.controllers;

import com.servicedesk.api.entities.User;
import com.servicedesk.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/users")
    public String getAll() {
        return "users";
    }

    @PostMapping(path = "/users")
    public String save() {
        return "user save";
    }
}
