package com.shadyplace.apiadmin.services;

import com.shadyplace.apiadmin.models.Role;
import com.shadyplace.apiadmin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByRoleName(String roleName) {
        return this.roleRepository.findFirstByRoleName(roleName);
    }

    public void save(Role role){
        this.roleRepository.save(role);
    }
}