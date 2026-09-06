package com.example.secure_device_monitor.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.secure_device_monitor.Entity.DeviceEntity;
import com.example.secure_device_monitor.Repository.DeviceRepository;
import com.example.secure_device_monitor.deviceserver.DeviceData;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceEntity saveDevice(DeviceData device) {

        DeviceEntity entity = new DeviceEntity();

        entity.setDeviceName(device.getDeviceName());
        entity.setManufacturer(device.getManufacturer());
        entity.setAndroidVersion(device.getAndroidVersion());
        entity.setBatteryPercentage(device.getBatteryPercentage());
        entity.setStorageInfo(device.getStorageInfo());
        entity.setCreatedAt(LocalDateTime.now());

        return deviceRepository.save(entity);
    }
    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }
}
