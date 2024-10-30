package com.example.application.classes.Devices.environment;

public class Detectors extends Environment {

    private boolean smokeDetected;           // Smoke detection
    private double carbonMonoxideLevel;      // Carbon monoxide level in ppm
    private boolean gasDetected;             // Gas detection
    private double temperature;              // Temperature in Celsius
    private int sensitivity;                 // Sensitivity of detection

    public Detectors(Long deviceId, String deviceName, String deviceBrand, int updateInterval,
                     boolean smokeDetected, double carbonMonoxideLevel,
                     boolean gasDetected, double temperature, int sensitivity) {

        super(deviceId, deviceName, deviceBrand, updateInterval);
        this.smokeDetected = smokeDetected;
        this.carbonMonoxideLevel = carbonMonoxideLevel;
        this.gasDetected = gasDetected;
        this.temperature = temperature;
        this.sensitivity = sensitivity;
    }

    @Override
    public void performMeasurement() {
        System.out.println("Performing measurement in Detectors");
        updateLastUpdateTime();
    }

    public void printLastUpdateTime() {
        System.out.println("Last update time: " + getLastUpdateTime());
    }

    public boolean isSmokeDetected() {
        return smokeDetected;
    }

    public void setSmokeDetected(boolean smokeDetected) {
        this.smokeDetected = smokeDetected;
    }

    public double getCarbonMonoxideLevel() {
        return carbonMonoxideLevel;
    }

    public void setCarbonMonoxideLevel(double carbonMonoxideLevel) {
        this.carbonMonoxideLevel = carbonMonoxideLevel;
    }

    public boolean isGasDetected() {
        return gasDetected;
    }

    public void setGasDetected(boolean gasDetected) {
        this.gasDetected = gasDetected;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() +
                "\nType: Detector" +
                "\nSmoke Detected: " + smokeDetected +
                "\nCarbon Monoxide Level: " + carbonMonoxideLevel + " ppm" +
                "\nGas Detected: " + gasDetected +
                "\nTemperature: " + temperature + " °C" +
                "\nSensitivity: " + sensitivity;
    }
}
