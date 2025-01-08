package com.servicedesk.api.controllers;

import com.servicedesk.api.entities.User;
import com.servicedesk.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/users")
    public String getAll() {
        List<User> users = this.userRepository.findAll();
        return users.toString();
    }

    @PostMapping(path = "/users")
    public User save(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping(path = "/users/{id}")
    public String getOne(@PathVariable Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.toString();
    }
}
