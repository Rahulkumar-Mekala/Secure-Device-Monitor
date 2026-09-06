package com.example.secure_device_monitor.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.secure_device_monitor.Entity.DeviceEntity;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
	  Optional<DeviceEntity> findByDeviceId(String deviceId);
}
