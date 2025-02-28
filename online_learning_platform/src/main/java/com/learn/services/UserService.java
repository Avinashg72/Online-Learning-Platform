package com.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.User;
import com.learn.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
    
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
