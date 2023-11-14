package com.example.security_example.UserService;

import com.example.security_example.model.Role;
import com.example.security_example.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllUser() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleRepository.save(role);

    }

    @Override
    public Role showUserById(Long id) {
        return roleRepository.getById(id);
    }
}
