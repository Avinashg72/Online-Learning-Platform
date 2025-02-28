package com.learn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.User;
import com.learn.model.AuthRequest;
import com.learn.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    
    public String authenticate(AuthRequest authRequest) {
        return userRepository.authenticate(authRequest);
    }
    
    public User register(User user) {
        return userRepository.register(user);
    }
}
