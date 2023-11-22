package com.example.security_example.controller;

import com.example.security_example.model.User;
import com.example.security_example.service.RoleService;
import com.example.security_example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final UserService userService;
    private final RoleService roleService;

    public ViewController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String showAllUser(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.getAllUser());
        return "admin_panel";
    }

    @GetMapping("/user")
    public String showOneUser() {
        return "user_panel";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
