package com.example.application.classes.Devices.Security;

import com.example.application.classes.Devices.Device;

public abstract class Security extends Device {


    public Security(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
    }

    public abstract void activate();
    public abstract void deactivate();


}
