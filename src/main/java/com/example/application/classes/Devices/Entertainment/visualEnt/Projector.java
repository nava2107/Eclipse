package com.example.application.classes.Devices.Entertainment.visualEnt;

import com.example.application.classes.Devices.Entertainment.Entertainment;

// Projector.java
public class Projector extends Entertainment {
    private int focusLevel;
    private boolean screenMirroringEnabled;

    public Projector(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.focusLevel = 50; // Default focus level
        this.screenMirroringEnabled = false;
    }

    public void adjustFocus(int level) {
        focusLevel = Math.max(0, Math.min(level, 100));
        System.out.println(super.getDeviceInfo() + " Focus adjusted to " + focusLevel + "%.");
    }

    public void enableScreenMirroring() {
        screenMirroringEnabled = true;
        System.out.println(super.getDeviceInfo() + " Screen mirroring enabled.");
    }

    public void disableScreenMirroring() {
        screenMirroringEnabled = false;
        System.out.println(super.getDeviceInfo() + " Screen mirroring disabled.");
    }
}

