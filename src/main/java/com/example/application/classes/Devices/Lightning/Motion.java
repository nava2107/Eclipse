package com.example.application.classes.Devices.Lightning;

public class Motion extends Lighting {
    private boolean motionDetected;
    private int motionSensitivity;

    public Motion(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.motionDetected = false;
        this.motionSensitivity = 5;
    }

    public void detectMotion() {
        motionDetected = true;
        System.out.println(super.getDeviceInfo() + " Motion detected!");
        this.turnOn();
    }

    public void setMotionSensitivity(int level) {
        this.motionSensitivity = Math.max(1, Math.min(level, 10));
        System.out.println(super.getDeviceInfo() + " Motion sensitivity set to " + motionSensitivity + ".");
    }

    public int getMotionSensitivity() {
        return motionSensitivity;
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + ", Type: Motion Lighting, Sensitivity: " + motionSensitivity;
    }
}

