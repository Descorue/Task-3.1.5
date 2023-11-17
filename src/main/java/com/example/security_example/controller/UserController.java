package com.example.security_example.controller;

import com.example.security_example.model.User;
import com.example.security_example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/userApi")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/{id}")
    public User showUserInfo(@RequestBody User user, @PathVariable("id") Long id) {
        userRepository.getById(id);
        return user;

    }
}
