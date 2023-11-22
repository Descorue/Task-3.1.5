package com.example.security_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/admin")
    public String showAllUser(Model model) {
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
