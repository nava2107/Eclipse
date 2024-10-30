package com.example.application.classes.Devices.Entertainment.visualEnt;

import com.example.application.classes.Devices.Device;

// SmartTV.java
public class VisualEntertainment extends Device {
    private String currentInput;
    private boolean streamingEnabled;

    public VisualEntertainment(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.currentInput = "HDMI1";
        this.streamingEnabled = true;
    }

    public void switchInput(String input) {
        currentInput = input;
        System.out.println(super.getDeviceInfo() + " Input switched to " + currentInput + ".");
    }

    public void enableStreaming() {
        streamingEnabled = true;
        System.out.println(super.getDeviceInfo() + " Streaming apps enabled.");
    }

    public void disableStreaming() {
        streamingEnabled = false;
        System.out.println(super.getDeviceInfo() + " Streaming apps disabled.");
    }
}
