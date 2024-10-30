package com.example.application.classes.Devices.environment;

import com.example.application.classes.Devices.Device;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Environment extends Device {

    private int updateInterval;
    private String lastUpdateTime;

    public Environment(Long deviceId, String deviceName, String deviceBrand, int updateInterval) {
        super(deviceId, deviceName, deviceBrand);
        this.updateInterval = updateInterval;
        this.lastUpdateTime = getCurrentTime();
    }

    public void updateLastUpdateTime() {
        this.lastUpdateTime = getCurrentTime();
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public abstract void performMeasurement();
}
