package com.example.secure_device_monitor.deviceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	  @PostMapping
	    public DeviceInfo receiveDeviceInfo(@RequestBody DeviceData device) {

	        System.out.println("Device: " + device.getDeviceName());
	        System.out.println("Manufacturer: " + device.getManufacturer());
	        System.out.println("Android: " + device.getAndroidVersion());
	        System.out.println("Battery: " + device.getBatteryPercentage());
	        System.out.println("Storage: " + device.getStorageInfo());

	        return new DeviceInfo(
	                device.getDeviceName(),
	                "Android",
	                "Connected"
	        );
	    }
}