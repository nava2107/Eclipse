package com.example.application.classes.Devices.Security;

public class Sensor extends Security {

    private boolean movement;

    public Sensor(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
    }

    /**
     * Metode som simulerer deteksjon av bevegelse basert på et hypotetisk input.
     * @param sensorInput Hypotetisk input fra sensoren som indikerer bevegelse (f.eks. en sensorverdi).
     * Her er tanken at man kan få opp notifikasjoner på enheten sin om det er bevegelse eller ikke,
     * ved å f.eks trykke på en knapp i front-end som kaller på denne funksjonen
     */
    public void detectMovement(int sensorInput) {
        // Her kan vi anta at sensorInput > 0 indikerer bevegelse
        if (sensorInput > 0) {
            this.movement = true;
            System.out.println("Movement detected!");
        } else {
            this.movement = false;
            System.out.println("No movement detected");
        }
    }

    public boolean isMovementDetected() {
        return movement;
    }


    @Override
    public void activate() {
        super.setActive(true);
        System.out.println("Sensor is now active.");
    }

    @Override
    public void deactivate() {
        super.setActive(false);
        System.out.println("Sensor is now inactive.");
    }
}
