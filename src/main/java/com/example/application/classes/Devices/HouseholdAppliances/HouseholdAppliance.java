package com.example.application.classes.Devices.HouseholdAppliances;

import com.example.application.classes.Devices.Device;

public abstract class HouseholdAppliance extends Device {


    private String applianceCategory;


    public HouseholdAppliance(Long deviceId, String deviceName, String deviceBrand, String applianceCategory) {
        super(deviceId, deviceName, deviceBrand);
        this.applianceCategory = applianceCategory;
    }


    public String getApplianceCategory() {
        return applianceCategory;
    }

    public void setApplianceCategory(String applianceCategory) {
        this.applianceCategory = applianceCategory;
    }


    public abstract void performSpecificAction();


    @Override
    public String getDeviceInfoLong() {
        return super.getDeviceInfoLong() + "\nCategory: " + applianceCategory;
    }
}
