package com.example.security_example.UserService;

import com.example.security_example.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllUser();

    void save(Role role);

    Role showUserById(Long id);
}
