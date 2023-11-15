package com.example.security_example.controller;


import com.example.security_example.service.RoleService;
import com.example.security_example.service.UserService;
import com.example.security_example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String printUsers(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.findAll());

        return "users";
    }

    @GetMapping("/create")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("role", roleService.getAllUser());
        return "create";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.save(user);

        return "redirect:/admin";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getById(id));
        modelMap.addAttribute("role", roleService.getAllUser());

        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute(value = "user") User user) {
        userService.update(user);

        return "redirect:/admin";
    }

    @PostMapping("users")
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteById(id);

        return "redirect:/admin";

    }
}

