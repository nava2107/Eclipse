package com.example.application.classes;

import com.example.application.classes.Devices.Device;

import java.util.ArrayList;
import java.util.UUID;

public class Family {

    private static int familyCount = 0;

    private int familyId;

    private String familyName;

    private ArrayList<User> familyMembers;

    private ArrayList<Device> householdDevices;

    // Brukeren som aller først lager en familie blir satt som admin. Kan endres senere dersom man ønsker det.
    private User admin;
    private String qrCode;

    // Konstruktør for en familie, hvor admin blir bestemt og familien får en tilhørende QR-kode
    // som kan brukes til å invitere nye familiemedlemmer
    public Family(String familyName, User admin) {
        this.familyId = ++familyCount;
        this.familyName = familyName;
        this.familyMembers = new ArrayList<>();
        this.householdDevices = new ArrayList<>();
        this.admin = admin;
        this.familyMembers.add(admin);
        this.qrCode = generateQRCode();
    }

    // Metode for å generere QR-kode
    private String generateQRCode() {
        return UUID.randomUUID().toString();
    }

    // Metode for å legge til familiemedlemmer gjennom familiens QR-kode
    public boolean addFamilyMemberWithQRCode(User newMember, String qrCodeInput) {
        if (this.qrCode.equals(qrCodeInput)) {
            this.familyMembers.add(newMember);
            return true;
        }
        return false;
    }


    public String getQrCode() {
        return qrCode;
    }



    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getFamilyId() {
        return familyId;
    }


    public ArrayList<User> getFamilyMembers() {
        return familyMembers;
    }


    public void addFamilyMember(User newMember) {
        this.familyMembers.add(newMember);
    }


    public void removeFamilyMember(User member) {
        this.familyMembers.remove(member);
    }


    public ArrayList<Device> getHouseholdDevices() {
        return householdDevices;
    }


    public void addDevice(Device newDevice) {
        this.householdDevices.add(newDevice);
    }


    public void removeDevice(Device device) {
        this.householdDevices.remove(device);
    }


    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }


    public static int getFamilyCount() {
        return familyCount;
    }


}
