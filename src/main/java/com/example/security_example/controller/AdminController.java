package com.example.security_example.controller;


import com.example.security_example.exceptionHandler.UserNotCreatedException;
import com.example.security_example.service.RoleService;
import com.example.security_example.service.UserService;
import com.example.security_example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adminApi")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //getting all users
    @GetMapping("/users")
    public List<User> printUsers() {
        return userService.findAll();
    }

    //getting ine user by id
    @GetMapping("users/{id}")
    public User getUser(@PathVariable(value = "id") Long id) {
        return userService.getById(id);
    }

    //creating new user and responding with ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors) {
                stringBuilder.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new UserNotCreatedException(stringBuilder.toString());
        }
        userService.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.update(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

