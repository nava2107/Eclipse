package com.example.application.classes.Devices.Energymanagement;

import com.example.application.classes.Devices.Device;

public abstract class Energy extends Device {

    public Energy(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
    }

    public abstract void displayStatus();
}
