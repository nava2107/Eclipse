package com.example.application.classes.Devices.Lightning;

public class SmartColour extends Lighting {
    private String color;
    private boolean isColorAdjustable;


    public SmartColour(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
        this.isDimmable = true;
        this.isColorAdjustable = true;
        this.color = "White";
    }

    public void setColor(String color) {
        if (isColorAdjustable) {
            this.color = color;
            System.out.println(super.getDeviceInfo() + " Color set to " + color + ".");
        } else {
            System.out.println(super.getDeviceInfo() + " Color adjustment is not supported.");
        }
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + ", Type: Smart Color Lighting, Color: " + color + ", Dimmable: " + isDimmable;
    }
}
