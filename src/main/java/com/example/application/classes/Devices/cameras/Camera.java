package com.example.application.classes.Devices.cameras;

import com.example.application.classes.Devices.Device;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Camera extends Device {

    private String resolution;
    private boolean nightVision;
    private boolean motionDetectionEnabled;
    private boolean autoTrackingEnabled;
    private boolean soundSensorEnabled;
    private String activationSchedule;

    public Camera(Long deviceId, String deviceName, String deviceBrand, String resolution, boolean nightVision,
                  boolean motionDetectionEnabled, boolean autoTrackingEnabled, boolean soundSensorEnabled,
                  String activationSchedule) {
        super(deviceId, deviceName, deviceBrand);
        this.resolution = resolution;
        this.nightVision = nightVision;
        this.motionDetectionEnabled = motionDetectionEnabled;
        this.autoTrackingEnabled = autoTrackingEnabled;
        this.soundSensorEnabled = soundSensorEnabled;
        this.activationSchedule = activationSchedule;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean hasNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    public boolean isMotionDetectionEnabled() {
        return motionDetectionEnabled;
    }

    public void setMotionDetectionEnabled(boolean motionDetectionEnabled) {
        this.motionDetectionEnabled = motionDetectionEnabled;
    }

    public boolean isAutoTrackingEnabled() {
        return autoTrackingEnabled;
    }

    public void setAutoTrackingEnabled(boolean autoTrackingEnabled) {
        this.autoTrackingEnabled = autoTrackingEnabled;
    }

    public boolean isSoundSensorEnabled() {
        return soundSensorEnabled;
    }

    public void setSoundSensorEnabled(boolean soundSensorEnabled) {
        this.soundSensorEnabled = soundSensorEnabled;
    }

    public String getActivationSchedule() {
        return activationSchedule;
    }

    public void setActivationSchedule(String activationSchedule) {
        this.activationSchedule = activationSchedule;
    }

    public boolean isActiveBasedOnSchedule(String currentTime) {
        if (activationSchedule == null || !activationSchedule.contains("-")) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.parse(currentTime, formatter);

        String[] times = activationSchedule.split("-");
        LocalTime start = LocalTime.parse(times[0], formatter);
        LocalTime end = LocalTime.parse(times[1], formatter);

        if (end.isBefore(start)) {
            return now.isAfter(start) || now.isBefore(end);
        } else {
            return now.isAfter(start) && now.isBefore(end);
        }
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + "\nResolution: " + resolution +
                "\nNight Vision: " + (nightVision ? "Enabled" : "Disabled") +
                "\nMotion Detection: " + (motionDetectionEnabled ? "Enabled" : "Disabled") +
                "\nAuto Tracking: " + (autoTrackingEnabled ? "Enabled" : "Disabled") +
                "\nSound Sensor: " + (soundSensorEnabled ? "Enabled" : "Disabled");
    }
}
