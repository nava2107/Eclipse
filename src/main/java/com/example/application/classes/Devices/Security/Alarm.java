package com.example.application.classes.Devices.Security;

public class Alarm extends Security {

    private boolean movement;

    public Alarm(Long deviceId, String deviceName, String deviceBrand) {
        super(deviceId, deviceName, deviceBrand);
    }
    /**
     * Metode som simulerer deteksjon av bevegelse basert på et hypotetisk input.
     * @param sensorInput Hypotetisk input fra sensoren som indikerer bevegelse (f.eks. en sensorverdi).
     */
    public void detectMovement(int sensorInput) {
        // Her kan vi anta at sensorInput > 0 indikerer bevegelse
        if (sensorInput > 0) {
            this.movement = true; // Bevegelse er detektert
            if (super.isActive()) {
                triggerAlarm(); // Utløs alarm hvis den er aktiv
            }
        } else {
            this.movement = false; // Ingen bevegelse
        }
    }

    // Metode for å utløse alarmen
    private void triggerAlarm() {
        System.out.println("The alarm has been triggered!");
        // Her kan du legge til logikk for å sende notifikasjoner til brukeren
    }

    public boolean isMovementDetected() {
        return movement;
    }
    @Override
    public void activate() {
        super.setActive(true);
        System.out.println("Alarm activated.");
    }

    @Override
    public void deactivate() {
        super.setActive(false);
        System.out.println("Alarm deactivated.");
    }
}