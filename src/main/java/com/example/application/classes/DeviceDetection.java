package com.example.application.classes;

import com.example.application.classes.Devices.Device;
import java.util.ArrayList;
import java.util.List;

public class DeviceDetection {

    private List<Device> devicesOnNetwork;

    public DeviceDetection() {
        this.devicesOnNetwork = new ArrayList<>();
    }

    public void scanForDevices() {
        System.out.println("Scanning the network for devices...");
    }

    public void addDeviceToNetwork(Device device) {
        if (!devicesOnNetwork.contains(device)) {
            devicesOnNetwork.add(device);
            System.out.println("Device detected: " + device.getDeviceName() + " (" + device.getDeviceBrand() + ")");
        } else {
            System.out.println("Device already exists on the network: " + device.getDeviceName());
        }
    }

    public void removeDeviceFromNetwork(Long deviceId) {
        devicesOnNetwork.removeIf(device -> device.getDeviceId().equals(deviceId));
        System.out.println("Removed device with ID: " + deviceId + " from the network.");
    }

    public void listDetectedDevices() {
        System.out.println("Devices currently on the network:");
        if (devicesOnNetwork.isEmpty()) {
            System.out.println("No devices detected on the network.");
        } else {
            for (Device device : devicesOnNetwork) {
                System.out.println(device.getDeviceInfoLong());
            }
        }
    }

    public void clearDetectedDevices() {
        devicesOnNetwork.clear();
        System.out.println("All devices removed from the network.");
    }
}
