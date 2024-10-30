package com.example.application.classes.Devices.Lightning;

import com.example.application.classes.Devices.Device;

public abstract class Lighting extends Device {
    public int brightness;
    public boolean isDimmable;

    public Lighting(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.isDimmable = true;
    }

    public void setDimmable(boolean dimmable) {
        isDimmable = dimmable;
    }

    void setBrightness(int level){
        if (isDimmable) {
            this.brightness = level;
            System.out.println(super.getDeviceInfo() + " Brightness set to " + brightness + ".");

        } else {
            System.out.println(super.getDeviceInfo() + " Brightness adjustment is not supported.");
        }
    }



    public int getBrightness() {
        return brightness;
    }

    public boolean getIsDimmable() {
        return isDimmable;
    }
}
