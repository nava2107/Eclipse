package com.example.application.classes.Devices.cameras;

public class OutDoor extends Camera {

    private boolean weatherResistant;
    private int range; //Rekkevidden kameraet kan se effektivt og tydelig i meter

    public OutDoor(Long deviceId, String deviceName, String deviceBrand, String resolution, boolean nightVision,
                   boolean motionDetectionEnabled, boolean autoTrackingEnabled, boolean soundSensorEnabled,
                   String activationSchedule, boolean weatherResistant, int range) {
        super(deviceId, deviceName, deviceBrand, resolution, nightVision, motionDetectionEnabled, autoTrackingEnabled, soundSensorEnabled, activationSchedule);
        this.weatherResistant = weatherResistant;
        this.range = range;
    }

    public boolean isWeatherResistant() {
        return weatherResistant;
    }

    public void setWeatherResistant(boolean weatherResistant) {
        this.weatherResistant = weatherResistant;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + "\nType: Outdoor Camera" +
                "\nWeather Resistant: " + (weatherResistant ? "Yes" : "No") +
                "\nRange: " + range + " meters";
    }
}
