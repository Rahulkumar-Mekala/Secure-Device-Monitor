package com.example.secure_device_monitor.deviceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @GetMapping
    public DeviceInfo getDeviceInfo() {
        return new DeviceInfo(
                "Test Phone",
                "Android",
                "Connected"
        );
    }
}
