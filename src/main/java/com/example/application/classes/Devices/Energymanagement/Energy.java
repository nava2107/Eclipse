package com.example.application.classes.Devices.Energymanagement;

public abstract class Energy {
    private String deviceName;

    public Energy(String deviceName){
        this.deviceName = deviceName;
    }

    public String getDeviceName(){
        return deviceName;
    }
    public abstract void displayStatus();
}
