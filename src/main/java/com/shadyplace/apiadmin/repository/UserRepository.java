package com.shadyplace.apiadmin.repository;

import com.shadyplace.apiadmin.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);


    @Query(value = "FROM User WHERE id != :id AND email = :email")
    List<User> findByEmailWithoutId(String email, Long id);

    @Override
    List<User> findAll();

    @Query(value = "FROM User u JOIN u.roles as roles WHERE u.email = :email AND roles.roleName = 'ADMIN'")
    User findByEmailAndAdminRole(String email);

}
