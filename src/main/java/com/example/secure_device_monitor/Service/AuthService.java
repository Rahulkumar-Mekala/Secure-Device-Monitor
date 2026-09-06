package com.example.secure_device_monitor.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.secure_device_monitor.Dto.LoginRequest;
import com.example.secure_device_monitor.Dto.RegisterRequest;
import com.example.secure_device_monitor.Entity.UserEntity;
import com.example.secure_device_monitor.Repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        UserEntity user = new UserEntity();

        user.setEmail(request.getEmail());


        user.setPassword( passwordEncoder.encode(request.getPassword()) );

        return userRepository.save(user);
    }

    public UserEntity login(LoginRequest request) {

        UserEntity user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password")
                );

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
}