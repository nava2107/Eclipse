package com.example.application.classes.Devices.Entertainment.soundSystem;

import com.example.application.classes.Devices.Device;
import com.example.application.classes.Devices.Entertainment.Entertainment;

public class SoundSystem extends Entertainment {
    private boolean bluetoothConnected;

    public SoundSystem(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.bluetoothConnected = false;
    }
    public boolean isBluetoothConnected() {
        return bluetoothConnected;
    }
    public void connectBluetooth() {
        bluetoothConnected = true;
        System.out.println(super.getDeviceInfo() + " Bluetooth connected.");
    }
    public void disconnectBluetooth() {
        bluetoothConnected = false;
        System.out.println(super.getDeviceInfo() + " Bluetooth disconnected.");
    }
}

