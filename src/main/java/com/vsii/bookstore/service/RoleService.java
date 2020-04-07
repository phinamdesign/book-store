package com.vsii.bookstore.service;

import com.vsii.bookstore.model.Role;
import com.vsii.bookstore.model.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName roleName);
}
