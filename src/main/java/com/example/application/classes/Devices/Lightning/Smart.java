package com.example.application.classes.Devices.Lightning;

public class Smart extends Lighting {

    public Smart(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.isDimmable = true;
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + ", Type: Smart Lighting (Dimmable)";
    }
}
