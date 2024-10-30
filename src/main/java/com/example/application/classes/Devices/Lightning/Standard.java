package com.example.application.classes.Devices.Lightning;

public class Standard extends Lighting {

    public Standard(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.isDimmable = false;
    }

    @Override
    public void setDimmable(boolean dimmable) {
        super.setDimmable(false);
    }

}
