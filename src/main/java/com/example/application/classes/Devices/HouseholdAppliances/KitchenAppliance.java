package com.example.application.classes.Devices.HouseholdAppliances;

import java.util.Timer;
import java.util.TimerTask;

public class KitchenAppliance extends HouseholdAppliance {

    // I denne klassen er det noen metoder som viser frem hvordan man skal kunne styre f.eks en smart-ovn
    // Her kan man også utvide for å legge til styring av eksempelvis en kaffemaskin eller smart-kjøleskap

    private String cookingMode;
    private int temperature;
    private int cookingTime;
    private boolean isCooking;

    public KitchenAppliance(Long deviceId, String deviceName, String deviceBrand, String cookingMode, int temperature) {
        super(deviceId, deviceName, deviceBrand, "Kitchen");
        this.cookingMode = cookingMode;
        this.temperature = temperature;
        this.cookingTime = 0;
        this.isCooking = false;
    }

    public String getCookingMode() {
        return cookingMode;
    }

    public void setCookingMode(String cookingMode) {
        this.cookingMode = cookingMode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isCooking() {
        return isCooking;
    }

    @Override
    public String getDeviceInfoLong() {
        return super.getDeviceInfoLong() + "\nCooking Mode: " + cookingMode + "\nTemperature: " + temperature + "°C" +
                "\nCooking Time: " + cookingTime + " minutes" + "\nIs Cooking: " + isCooking;
    }

    public void startCooking() {
        if (!isActive()) {
            turnOn();
        }
        isCooking = true;
        System.out.println(getDeviceName() + " is starting " + cookingMode + " at " + temperature + "°C.");

        if (cookingTime > 0) {
            System.out.println("Cooking will continue for " + cookingTime + " minutes.");
            scheduleCookingTask();
        } else {
            System.out.println("No cooking time set, cooking will continue indefinitely until stopped.");
        }
    }

    public void stopCooking() {
        if (isActive()) {
            turnOff();
        }
        isCooking = false;
        System.out.println(getDeviceName() + " has stopped cooking.");
    }

    public void setCookingTimer(int minutes) {
        this.cookingTime = minutes;
        System.out.println("Cooking timer set for " + minutes + " minutes.");
    }

    public void preheatOven(int targetTemperature) {
        System.out.println(getDeviceName() + " is preheating to " + targetTemperature + "°C.");
        this.temperature = targetTemperature;
        turnOn();
    }

    public void activateSmartCookingMode(String mode) {
        System.out.println(getDeviceName() + " is now in " + mode + " mode.");
        this.cookingMode = mode;
    }

    private void scheduleCookingTask() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                stopCooking();
                System.out.println("Cooking finished after " + cookingTime + " minutes.");
            }
        }, cookingTime * 60000);
    }

    @Override
    public void performSpecificAction() {
        System.out.println(getDeviceName() + " is currently in " + cookingMode + " mode at " + temperature + "°C.");
    }
}
