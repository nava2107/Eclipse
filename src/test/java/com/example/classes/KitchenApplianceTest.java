package com.example.classes;


import com.example.application.classes.Devices.HouseholdAppliances.KitchenAppliance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitchenApplianceTest {

    private KitchenAppliance kitchenAppliance;

    @BeforeEach
    void setUp() {
        kitchenAppliance = new KitchenAppliance(1L, "Smart Oven", "BrandX", "Baking", 180);
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Initial Setup")
    void testInitialSetup() {
        assertEquals("Smart Oven", kitchenAppliance.getDeviceName());
        assertEquals("BrandX", kitchenAppliance.getDeviceBrand());
        assertEquals("Kitchen", kitchenAppliance.getApplianceCategory());
        assertEquals("Baking", kitchenAppliance.getCookingMode());
        assertEquals(180, kitchenAppliance.getTemperature());
        assertFalse(kitchenAppliance.isCooking());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Start Cooking")
    void testStartCooking() {
        kitchenAppliance.setCookingTime(30);
        kitchenAppliance.startCooking();
        assertTrue(kitchenAppliance.isCooking());
        assertTrue(kitchenAppliance.isActive());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Stop Cooking")
    void testStopCooking() {
        kitchenAppliance.startCooking();
        kitchenAppliance.stopCooking();
        assertFalse(kitchenAppliance.isCooking());
        assertFalse(kitchenAppliance.isActive());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Set Cooking Timer")
    void testSetCookingTimer() {
        kitchenAppliance.setCookingTimer(45);
        assertEquals(45, kitchenAppliance.getCookingTime());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Preheat Oven")
    void testPreheatOven() {
        kitchenAppliance.preheatOven(200);
        assertEquals(200, kitchenAppliance.getTemperature());
        assertTrue(kitchenAppliance.isActive());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Activate Smart Cooking Mode")
    void testActivateSmartCookingMode() {
        kitchenAppliance.activateSmartCookingMode("Grilling");
        assertEquals("Grilling", kitchenAppliance.getCookingMode());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Get Device Info Long")
    void testGetDeviceInfoLong() {
        kitchenAppliance.setCookingTime(30);
        kitchenAppliance.startCooking();
        String expectedInfo = "Device: Smart Oven\nBrand: BrandX\nActive: true\nCategory: Kitchen\nCooking Mode: Baking\nTemperature: 180°C\nCooking Time: 30 minutes\nIs Cooking: true";
        assertEquals(expectedInfo, kitchenAppliance.getDeviceInfoLong());
    }

    @Test
    @DisplayName("Test: KitchenAppliance - Perform Specific Action")
    void testPerformSpecificAction() {
        kitchenAppliance.performSpecificAction();
    }
}

