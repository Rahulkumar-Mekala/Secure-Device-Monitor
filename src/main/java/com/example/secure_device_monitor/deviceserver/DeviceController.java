package com.example.secure_device_monitor.deviceserver;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.secure_device_monitor.Entity.DeviceEntity;
import com.example.secure_device_monitor.Service.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    
    @GetMapping
    public List<DeviceEntity> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public DeviceInfo receiveDeviceInfo(
            @RequestBody DeviceData device) {

        deviceService.saveDevice(device);

        return new DeviceInfo(
                device.getDeviceName(),
                "Android",
                "Connected"
        );
    }
}