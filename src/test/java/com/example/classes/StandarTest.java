package com.example.classes;

import com.example.application.classes.Devices.Lightning.Standard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Standar Class Tests")
class StandarTest {

    private Standard lighting;

    @BeforeEach
    void setUp() {
        lighting = new Standard(1L, "Living Room Light", "Philips");
        System.out.println("Set up Standar object: " + lighting.getDeviceInfo());
    }

    @Test
    @DisplayName("test: should not allow brightness adjustment when not dimmable")
    void testSetBrightness_WhenNotDimmable() {
        System.out.println("Running testSetBrightness_WhenNotDimmable");
        lighting.setBrightness(50); // Attempting to set brightness
        assertEquals(0, lighting.getBrightness()); // Brightness should remain at 0
        System.out.println("Brightness remains unchanged: " + lighting.getBrightness());
    }

    @Test
    @DisplayName("test: should return dimmable state as false")
    void testGetIsDimmable() {
        System.out.println("Running testGetIsDimmable");
        assertFalse(lighting.getIsDimmable(), "Lighting should not be dimmable");
        System.out.println("Dimmable state verified as false: " + lighting.getIsDimmable());
    }

    @Test
    @DisplayName("test: should keep dimmable state as false when attempting to set it")
    void testSetDimmable() {
        System.out.println("Running testSetDimmable");
        lighting.setDimmable(true); // Attempt to set dimmable to true
        assertFalse(lighting.getIsDimmable(), "Lighting should remain non-dimmable");
        System.out.println("Dimmable state remains false: " + lighting.getIsDimmable());
    }

    @Test
    @DisplayName("test: should set brightness to 0 since it is non-dimmable")
    void testSetBrightness_AlwaysZero() {
        System.out.println("Running testSetBrightness_AlwaysZero");
        lighting.setBrightness(100); // Attempt to set brightness
        assertEquals(0, lighting.getBrightness(), "Brightness should always be 0 for non-dimmable lights");
        System.out.println("Brightness confirmed as 0: " + lighting.getBrightness());
    }
}

