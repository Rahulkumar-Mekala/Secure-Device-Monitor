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

    public DeviceEntity saveOrUpdateDevice(DeviceData data) {

        DeviceEntity device = deviceRepository.findByDeviceId(data.getDeviceId())
                .orElse(new DeviceEntity());

        device.setDeviceId(data.getDeviceId());
        device.setDeviceName(data.getDeviceName());
        device.setManufacturer(data.getManufacturer());
        device.setAndroidVersion(data.getAndroidVersion());
        device.setBatteryPercentage(data.getBatteryPercentage());
        device.setStorageInfo(data.getStorageInfo());

        if (device.getCreatedAt() == null) {
            device.setCreatedAt(LocalDateTime.now());
        }

        return deviceRepository.save(device);
    }
    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }
}
