package com.example.classes;

import com.example.application.classes.Devices.cameras.Camera;
import com.example.application.classes.Devices.cameras.InDoor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InDoor Camera Class Tests")
class CameraTest {

    private Camera indoorCamera;

    @BeforeEach
    void setUp() {
        indoorCamera = new InDoor(1L, "Security Cam", "SafeHome", "1080p", true, true, true, true, "22:00-06:00");
    }

    @Test
    @DisplayName("Test: Camera Initialization")
    void testCameraInitialization() {
        assertEquals("1080p", indoorCamera.getResolution());
        assertTrue(indoorCamera.hasNightVision());
        assertTrue(indoorCamera.isMotionDetectionEnabled());
        assertTrue(indoorCamera.isAutoTrackingEnabled());
        assertTrue(indoorCamera.isSoundSensorEnabled());
        assertEquals("22:00-06:00", indoorCamera.getActivationSchedule());
    }

    @Test
    @DisplayName("Test: Camera Info Display")
    void testGetDeviceInfo() {
        String actualInfo = indoorCamera.getDeviceInfo();
        System.out.println("Actual Device Info:\n" + actualInfo);

        String expectedInfo =
                "Device: Security Cam\n" +
                "Brand: SafeHome\n" +
                "Active: true\n" +
                "Resolution: 1080p\n" +
                "Night Vision: Enabled\n" +
                "Motion Detection: Enabled\n" +
                "Auto Tracking: Enabled\n" +
                "Sound Sensor: Enabled\n" +
                "Type: Indoor Camera";

        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    @DisplayName("Test: Camera Activation within Schedule")
    void testIsActiveBasedOnSchedule_Active() {
        assertTrue(indoorCamera.isActiveBasedOnSchedule("23:00"), "Camera should be active at 23:00.");
    }

    @Test
    @DisplayName("Test: Camera Activation outside Schedule")
    void testIsActiveBasedOnSchedule_Inactive() {
        assertFalse(indoorCamera.isActiveBasedOnSchedule("12:00"), "Camera should be inactive at 12:00.");
    }

    @Test
    @DisplayName("Test: Overnight Activation Schedule")
    void testIsActiveBasedOnSchedule_Overnight() {
        assertTrue(indoorCamera.isActiveBasedOnSchedule("01:00"), "Camera should be active at 01:00.");
        assertFalse(indoorCamera.isActiveBasedOnSchedule("07:00"), "Camera should be inactive at 07:00.");
    }
}
