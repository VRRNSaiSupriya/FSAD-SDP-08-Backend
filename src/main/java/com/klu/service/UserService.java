package com.klu.service;

import com.klu.model.User;
import com.klu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // REGISTER
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // LOGIN
    public User login(String email, String password) {
        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null && existingUser.getPassword().equals(password)) {
            return existingUser;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}