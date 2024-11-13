package com.example.application.classes.Devices;

import java.util.ArrayList;
import java.util.List;

public class SuggestedDevices {

    private List<Device> suggestedDevices;

    public SuggestedDevices() {
        this.suggestedDevices = new ArrayList<>();
    }

    public void addSuggestedDevice(Device device) {
        suggestedDevices.add(device);
        System.out.println("Added suggested device: " + device.getDeviceName() + " (" + device.getDeviceBrand() + ")");
    }

    public void listSuggestedDevices() {
        System.out.println("Suggested devices:");
        for (Device device : suggestedDevices) {
            System.out.println(device.getDeviceInfoLong());
        }
    }

    public class SearchDevices {

        public List<Device> searchByName(String name) {
            List<Device> results = new ArrayList<>();
            for (Device device : suggestedDevices) {
                if (device.getDeviceName().equalsIgnoreCase(name)) {
                    results.add(device);
                }
            }
            return results;
        }

        public List<Device> searchByBrand(String brand) {
            List<Device> results = new ArrayList<>();
            for (Device device : suggestedDevices) {
                if (device.getDeviceBrand().equalsIgnoreCase(brand)) {
                    results.add(device);
                }
            }
            return results;
        }

        public List<Device> searchByActiveStatus(boolean isActive) {
            List<Device> results = new ArrayList<>();
            for (Device device : suggestedDevices) {
                if (device.isActive() == isActive) {
                    results.add(device);
                }
            }
            return results;
        }
    }

    public SearchDevices getSearchDevices() {
        return new SearchDevices();
    }
}
