package com.shadyplace.apiadmin.repository;

import com.shadyplace.apiadmin.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {


    Role findFirstByRoleName(String role);

    @Override
    public List<Role> findAll();

}
