package com.example.application.classes.Devices.Energymanagement.Meters;

import com.example.application.classes.Devices.Energymanagement.Energy;

public class WaterMeter extends Energy {
    private double totalUsage;

    public WaterMeter(String deviceName) {
        super(deviceName);
        this.totalUsage = 0.0;
    }

    public void addUsage(double usage) {
        totalUsage += usage;
    }

    public double getTotalUsage() {
        return totalUsage;
    }

    @Override
    public void displayStatus() {
        System.out.println(getDeviceName() + " - Total Water Usage: " + totalUsage + " liters");
    }
}
