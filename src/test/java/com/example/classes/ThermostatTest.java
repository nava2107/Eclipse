package com.example.classes;


import com.example.application.classes.Devices.environment.Thermostat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Thermostat Class Tests")
class ThermostatTest {

    private Thermostat thermostat;

    @BeforeEach
    void setUp() {
        thermostat = new Thermostat(1L, "Home Thermostat", "Nest", 60, 22.0, 20.0, "Auto", 3, true, "08:00-22:00");
        System.out.println("Set up Thermostat object: " + thermostat.getDeviceInfo());
    }

    @Test
    @DisplayName("test: should return the correct target temperature")
    void testGetTargetTemperature() {
        System.out.println("Running testGetTargetTemperature");
        assertEquals(22.0, thermostat.getTargetTemperature());
    }

    @Test
    @DisplayName("test: should set the target temperature correctly")
    void testSetTargetTemperature() {
        System.out.println("Running testSetTargetTemperature");
        thermostat.setTargetTemperature(24.0);
        assertEquals(24.0, thermostat.getTargetTemperature());
        System.out.println("Target temperature set successfully: " + thermostat.getTargetTemperature());
    }

    @Test
    @DisplayName("test: should check eco mode status")
    void testIsEcoModeActive() {
        System.out.println("Running testIsEcoModeActive");
        assertTrue(thermostat.isEcoModeActive(), "Eco mode should be active.");
    }

    @Test
    @DisplayName("test: should not activate eco mode when in Off mode")
    void testIsEcoModeActive_WhenInOffMode() {
        System.out.println("Running testIsEcoModeActive_WhenInOffMode");
        thermostat.setMode("Off");
        assertFalse(thermostat.isEcoModeActive(), "Eco mode should not be active when mode is Off.");
    }

    @Test
    @DisplayName("test: should perform measurement and update last update time")
    void testPerformMeasurement() {
        System.out.println("Running testPerformMeasurement");
        thermostat.performMeasurement();
        assertNotNull(thermostat.getLastUpdateTime(), "Last update time should be updated.");
        System.out.println("Measurement performed and last update time verified.");
    }

    @Test
    @DisplayName("test: should return correct device info")
    void testGetDeviceInfo() {
        System.out.println("Running testGetDeviceInfo");
        String expectedInfo = "Device: Home Thermostat\n"+
                "Brand: Nest\n" +
                "Active: true\n"+
                "Type: Thermostat\n" +
                "Target Temperature: 22.0 °C\n"+
                "Current Temperature: 20.0 °C\n" +
                "Mode: Auto\n"+
                "Fan Speed: 3\n"+
                "Eco Mode: Enabled\n"+
                "Schedule: 08:00-22:00";
        assertEquals(expectedInfo, thermostat.getDeviceInfo());
        System.out.println("Device info returned successfully.");
    }
}

