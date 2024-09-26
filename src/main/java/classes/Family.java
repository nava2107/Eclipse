package classes;

import java.util.ArrayList;
import java.util.UUID;

public class Family {

    private static int familyCount = 0;

    private int familyId;

    private String familyName;

    private ArrayList<User> familyMembers;

    private ArrayList<Device> householdDevices;

    private User admin;
    private String qrCode;


    public Family(String familyName, User admin) {
        this.familyId = ++familyCount;
        this.familyName = familyName;
        this.familyMembers = new ArrayList<>();
        this.householdDevices = new ArrayList<>();
        this.admin = admin;
        this.familyMembers.add(admin);
        this.qrCode = generateQRCode();
    }

    private String generateQRCode() {
        return UUID.randomUUID().toString();
    }

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


    // Getter and setter methods for familyName
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    // Getter and setter methods for familyId (no setter, since ID is auto-generated)
    public int getFamilyId() {
        return familyId;
    }

    // Getter and setter methods for familyMembers
    public ArrayList<User> getFamilyMembers() {
        return familyMembers;
    }

    // Add a member to the family
    public void addFamilyMember(User newMember) {
        this.familyMembers.add(newMember);
    }

    // Remove a member from the family
    public void removeFamilyMember(User member) {
        this.familyMembers.remove(member);
    }

    // Getter and setter methods for householdDevices
    public ArrayList<Device> getHouseholdDevices() {
        return householdDevices;
    }

    // Add a device to the household devices list
    public void addDevice(Device newDevice) {
        this.householdDevices.add(newDevice);
    }

    // Remove a device from the household devices list
    public void removeDevice(Device device) {
        this.householdDevices.remove(device);
    }

    // Getter and setter methods for admin
    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    // Static method to get the total number of families created
    public static int getFamilyCount() {
        return familyCount;
    }


}
