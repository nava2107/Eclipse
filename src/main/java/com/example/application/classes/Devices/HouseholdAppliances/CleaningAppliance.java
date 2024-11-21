package com.example.application.classes.Devices.HouseholdAppliances;

import java.util.Timer;
import java.util.TimerTask;

public class CleaningAppliance extends HouseholdAppliance {

    private String cleaningMode;
    private int powerLevel;
    private int cleaningDuration;
    private String cleaningArea;

    public CleaningAppliance(Long deviceId, String deviceName, String deviceBrand, String cleaningMode, int powerLevel) {
        super(deviceId, deviceName, deviceBrand, "Cleaning");
        this.cleaningMode = cleaningMode;
        this.powerLevel = powerLevel;
        this.cleaningDuration = 0;
        this.cleaningArea = "Whole House";
    }

    public String getCleaningMode() {
        return cleaningMode;
    }

    public void setCleaningMode(String cleaningMode) {
        this.cleaningMode = cleaningMode;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getCleaningDuration() {
        return cleaningDuration;
    }

    public void setCleaningDuration(int cleaningDuration) {
        this.cleaningDuration = cleaningDuration;
    }

    public String getCleaningArea() {
        return cleaningArea;
    }

    public void setCleaningArea(String cleaningArea) {
        this.cleaningArea = cleaningArea;
    }

    @Override
    public String getDeviceInfoLong() {
        return super.getDeviceInfoLong() + "\nCleaning Mode: " + cleaningMode + "\nPower Level: " + powerLevel +
                "\nCleaning Duration: " + cleaningDuration + " minutes\nCleaning Area: " + cleaningArea;
    }

    // Denne metoden demonstrerer at man skal kunne skru på f.eks en robotstøvsuger eller annet IoT vaske-produkt
    public void startCleaning() {
        if (!isActive()) {
            turnOn();
        }
        System.out.println(getDeviceName() + " is starting cleaning in " + cleaningMode + " mode with power level " + powerLevel);
        System.out.println("Cleaning the area: " + cleaningArea);

        if (cleaningDuration > 0) {
            System.out.println("The cleaning will run for " + cleaningDuration + " minutes.");
            scheduleCleaningTask();
        } else {
            System.out.println("No duration set. The cleaning will continue until manually stopped.");
        }
    }

    // Demonstrerer at man skal kunne stoppe IoT vaske-enheten
    public void stopCleaning() {
        if (isActive()) {
            turnOff();
        }
        System.out.println(getDeviceName() + " has stopped cleaning.");
    }

    // Denne metoden demonstrerer at man skal kunne velge i appen hvor lenge enheten skal vaske
    public void chooseCleaningDuration(int minutes) {
        this.cleaningDuration = minutes;
        System.out.println("Cleaning duration is set to " + minutes + " minutes.");
    }

    // Denne metoden demonstrerer at man skal kunne velge i appen hvilke områder i huset enheten skal vaske
    public void chooseCleaningArea(String area) {
        this.cleaningArea = area;
        System.out.println("Cleaning area set to: " + area);
    }

    @Override
    public void performSpecificAction() {
        System.out.println(getDeviceName() + " is performing cleaning action.");
    }


    // Denne metoden skal demonstrere at appen skal tillate brukere å planlegge arbeid for vaske-enheten
    private void scheduleCleaningTask() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                stopCleaning();
                System.out.println("Cleaning has finished after " + cleaningDuration + " minutes.");
            }
        }, cleaningDuration * 60000);
    }
}
