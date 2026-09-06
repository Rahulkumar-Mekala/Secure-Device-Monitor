package com.example.secure_device_monitor.deviceserver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceData {

    private String deviceName;
    private String manufacturer;
    private String androidVersion;
    private int batteryPercentage;
    private String storageInfo;

}