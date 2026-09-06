package com.example.secure_device_monitor.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private Long id;
    private String email;
    private String message;
}