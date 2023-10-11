package com.shadyplace.apiadmin.services;

import com.shadyplace.apiadmin.models.User;
import com.shadyplace.apiadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void save(User user){
        this.userRepository.save(user);
    }

    public User findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRegistrationDate(Calendar.getInstance());
        return this.userRepository.save(user);
    }

    public User updateUser(User user){
        return this.userRepository.save(user);
    }

    public List<User> findByEmailAndNotId(String email, Long id){
        return this.userRepository.findByEmailWithoutId(email, id);
    }

    public void delete(User user){
        this.userRepository.delete(user);
    }


}
