package com.example.application.classes.Devices.environment;

public class Thermostat extends Environment {

    private double targetTemperature;
    private double currentTemperature;
    private String mode;
    private int fanSpeed;
    private boolean ecoMode;
    private String schedule;

    public Thermostat(Long deviceId, String deviceName, String deviceBrand, int updateInterval,
                      double targetTemperature, double currentTemperature, String mode,
                      int fanSpeed, boolean ecoMode, String schedule) {
        super(deviceId, deviceName, deviceBrand, updateInterval);
        this.targetTemperature = targetTemperature;
        this.currentTemperature = currentTemperature;
        this.mode = mode;
        this.fanSpeed = fanSpeed;
        this.ecoMode = ecoMode;
        this.schedule = schedule;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public boolean isEcoMode() {
        return ecoMode;
    }

    public void setEcoMode(boolean ecoMode) {
        this.ecoMode = ecoMode;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public void performMeasurement() {
        System.out.println("Checking and adjusting temperature in Thermostat.");
        updateLastUpdateTime();
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() +
                "\nType: Thermostat" +
                "\nTarget Temperature: " + targetTemperature + " °C" +
                "\nCurrent Temperature: " + currentTemperature + " °C" +
                "\nMode: " + mode +
                "\nFan Speed: " + fanSpeed +
                "\nEco Mode: " + (ecoMode ? "Enabled" : "Disabled") +
                "\nSchedule: " + schedule;
    }

    public boolean isEcoModeActive() {
        return ecoMode && (mode.equals("Auto") || mode.equals("Heat") || mode.equals("Cool"));
    }

    public void applySchedule(String currentTime) {
        System.out.println("Applying schedule for Thermostat at " + currentTime);
    }
}
