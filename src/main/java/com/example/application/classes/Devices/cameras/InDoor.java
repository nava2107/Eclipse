package com.example.application.classes.Devices.cameras;

public class InDoor extends Camera {

    public InDoor(Long deviceId, String deviceName, String deviceBrand, String resolution, boolean nightVision,
                  boolean motionDetectionEnabled, boolean autoTrackingEnabled, boolean soundSensorEnabled,
                  String activationSchedule) {
        super(deviceId, deviceName, deviceBrand, resolution, nightVision, motionDetectionEnabled, autoTrackingEnabled, soundSensorEnabled, activationSchedule);
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + "\nType: Indoor Camera";
    }
}
