package com.servicedesk.api.controllers;

import com.servicedesk.api.entities.User;
import com.servicedesk.api.entities.dto.CreateUserDto;
import com.servicedesk.api.entities.dto.GetUserDto;
import com.servicedesk.api.exceptions.UserNotFoundException;
import com.servicedesk.api.repositories.UserRepository;
import com.servicedesk.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<GetUserDto> save(@RequestBody CreateUserDto userDto) {
        var user = userService.save(new User(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(new GetUserDto(user));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id) {
        try {
            User user = this.userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(id));
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new User());
        }
    }
}
