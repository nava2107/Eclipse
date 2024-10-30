package com.example.application.classes.Devices.Entertainment;

import com.example.application.classes.Devices.Device;

public abstract class Entertainment extends Device {
    private int volume;

    public Entertainment(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.volume = 40;
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(int level) {
        volume = Math.max(0, Math.min(level, 100));
        System.out.println(super.getDeviceInfo() + " Volume set to " + volume + "%.");
    }

}
