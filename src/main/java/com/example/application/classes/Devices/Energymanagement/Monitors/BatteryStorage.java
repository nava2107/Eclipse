package com.example.application.classes.Devices.Energymanagement.Monitors;

import com.example.application.classes.Devices.Energymanagement.Energy;

public class BatteryStorage extends Energy {
    private double batteryLevel;

    public BatteryStorage(Long deviceId, String deviceName, String deviceBrand){
        super(deviceId, deviceName, deviceBrand);
        this.batteryLevel = 100.0;
    }

    public void discharge(double amount) {
        batteryLevel = Math.max(0, batteryLevel - amount);
    }

    public void charge(double amount) {
        batteryLevel = Math.min(100, batteryLevel + amount);
    }

    @Override
    public void displayStatus() {
        System.out.println(getDeviceName() + " - Battery Level: " + batteryLevel + "%");
    }
}
