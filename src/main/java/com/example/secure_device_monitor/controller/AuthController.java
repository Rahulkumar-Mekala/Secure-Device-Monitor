package com.example.secure_device_monitor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.secure_device_monitor.Dto.LoginRequest;
import com.example.secure_device_monitor.Dto.RegisterRequest;
import com.example.secure_device_monitor.Entity.UserEntity;
import com.example.secure_device_monitor.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserEntity register(
            @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public UserEntity login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}