package com.servicedesk.api.services;

import com.servicedesk.api.entities.User;
import com.servicedesk.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        return this.userRepository.save(user);
    }

    public Page<User> findAll(Pageable pagination) {
        return this.userRepository.findAllByDeletedAtIsNull(pagination);
    }

}
