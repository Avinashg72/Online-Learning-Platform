package com.learn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entities.User;
import com.learn.model.AuthRequest;
import com.learn.services.AuthService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }
}
