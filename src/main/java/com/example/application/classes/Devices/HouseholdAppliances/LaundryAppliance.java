package com.example.application.classes.Devices.HouseholdAppliances;

public class LaundryAppliance extends HouseholdAppliance {

    private String laundryCycle;
    private int temperature;


    public LaundryAppliance(Long deviceId, String deviceName, String deviceBrand, String laundryCycle, int temperature) {
        super(deviceId, deviceName, deviceBrand, "Laundry");
        this.laundryCycle = laundryCycle;
        this.temperature = temperature;
    }


    public String getLaundryCycle() {
        return laundryCycle;
    }

    public void setLaundryCycle(String laundryCycle) {
        this.laundryCycle = laundryCycle;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


    @Override
    public String getDeviceInfoLong() {
        return super.getDeviceInfoLong() + "\nLaundry Cycle: " + laundryCycle + "\nTemperature: " + temperature + "°C";
    }

    // Denne metoden skal demonstrere at man kan starte klesvasken gjennom appen
    public void startWashing() {
        if (!isActive()) {
            turnOn();
        }
        System.out.println(getDeviceName() + " is starting the " + laundryCycle + " wash cycle at " + temperature + "°C.");

    }

    // Denne metoden skal demonstrere at man kan starte tørkeprosessen gjennom appen
    public void startDrying() {
        if (!isActive()) {
            turnOn();
        }
        System.out.println(getDeviceName() + " is starting the drying cycle at " + temperature + "°C.");

    }


    @Override
    public void performSpecificAction() {
        System.out.println(getDeviceName() + " is performing its current cycle (" + laundryCycle + ").");
    }
}
