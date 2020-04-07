package com.vsii.bookstore.service.impl;

import com.vsii.bookstore.model.Role;
import com.vsii.bookstore.model.RoleName;
import com.vsii.bookstore.repository.RoleRepository;
import com.vsii.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }
}
