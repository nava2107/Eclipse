package com.example.application.classes;

import com.example.application.classes.Devices.Device;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomId;
    private String roomName;
    private List<Device> devices;

    public Room(int roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.devices = new ArrayList<>();
    }

    public int getRoomId() { return roomId; }
    public String getRoomName() { return roomName; }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Added device: " + device.getDeviceName() + " to room: " + roomName);
    }

    public void removeDevice(Long deviceId) {
        devices.removeIf(device -> device.getDeviceId().equals(deviceId));
        System.out.println("Removed device with ID: " + deviceId + " from room: " + roomName);
    }

    public void listDevices() {
        System.out.println("Devices in room: " + roomName);
        for (Device device : devices) {
            System.out.println(device.getDeviceInfoLong());
        }
    }

    public void listDevicesByBrand(String brand) {
        System.out.println("Devices of brand " + brand + " in room: " + roomName);
        for (Device device : devices) {
            if (device.getDeviceBrand().equalsIgnoreCase(brand)) {
                System.out.println(device.getDeviceInfoLong());
            }
        }
    }

    public void turnOnAllDevices() {
        System.out.println("Turning on all devices in room: " + roomName);
        for (Device device : devices) {
            device.turnOn();
        }
    }

    public void turnOffAllDevices() {
        System.out.println("Turning off all devices in room: " + roomName);
        for (Device device : devices) {
            device.turnOff();
        }
    }
}
