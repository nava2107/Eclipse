package com.example.application.classes.Devices.Energymanagement.Meters;

import com.example.application.classes.Devices.Energymanagement.Energy;

public class ElectricityMeter extends Energy {
    private double totalUsage;
    public ElectricityMeter(Long deviceId, String deviceName, String deviceBrand){
        super(deviceId, deviceName, deviceBrand);
        this.totalUsage = 0.0;
    }
    public void addUsage(double usage) {
        totalUsage += usage;
    }
    public double getTotalUsage(){
        return totalUsage;
    }

    @Override
    public void displayStatus(){
        System.out.println(getDeviceName() + "- Total Usage: " + totalUsage + " kWh");
    }
}
