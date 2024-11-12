package com.example.application.classes.Devices.Energymanagement.PowerControl;

import com.example.application.classes.Devices.Energymanagement.Energy;

public class SmartPlug extends Energy {
    private boolean isOn;

    public SmartPlug(String deviceName){
        super(deviceName);
        this.isOn = false;
    }

    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }

    @Override
    public void displayStatus(){
        System.out.println(getDeviceName() + " is " + (isOn ? "ON" : "OFF"));
    }
}