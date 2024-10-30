package com.example.application.classes.Devices;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "devices")
public abstract class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;

    private String deviceName;
    private String deviceBrand;
    private boolean isActive;

    public Device(){}

    public Device(Long deviceId, String deviceName, String deviceBrand) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceBrand = deviceBrand;
        this.isActive = true;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        this.isActive = false;
    }
    public String getDeviceInfo() {
        return "Device: " + deviceName + "/n" + isActive;
    }
    public String getDeviceInfoLong() {
        return "Device: " + deviceName + "/nBrand" + deviceBrand + "/n" + isActive;
    }
    public void turnOn() {
        isActive = true;
        System.out.println(deviceName + " is now ON.");
    }

    public void turnOff() {
        isActive = false;
        System.out.println(deviceName + " is now OFF.");
    }
}