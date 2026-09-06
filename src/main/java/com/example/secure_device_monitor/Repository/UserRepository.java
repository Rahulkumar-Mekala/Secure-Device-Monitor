package com.example.secure_device_monitor.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.secure_device_monitor.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

Optional<UserEntity> findByEmail(String email);
}