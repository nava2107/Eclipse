package com.example.application.classes;
import java.util.ArrayList;
import java.util.List;

import com.example.application.classes.Devices.Device;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY) // or another strategy based on your DB
    @Column(name = "USERID", nullable = false)
    private int userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "HASHED_PASSWORD")
    private String hashedPassword;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive = true;

    @Column(name = "IS_AUTHENTICATED", nullable = false)
    private boolean isAuthenticated = false;

    @Column(name = "IS_EMAIL_VERIFIED", nullable = false)
    private boolean isEmailVerified = false;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin = false;

    @Column(name = "VERIFICATION_CODE")
    private String verificationCode;

    // devices er en liste med devices som er relatert til brukeren
    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL, fetch = jakarta.persistence.FetchType.LAZY)
    private List<Device> devices = new ArrayList<>();


    // Konstruktør som lager user-objekter
    public User(String username, String firstName, String lastName, String email, String hashedPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.isActive = true;
        this.isAuthenticated = false;
        this.isEmailVerified = false;
        this.isAdmin = false;
        this.devices = new ArrayList<>();
    }

    public User(){}

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.isEmailVerified = emailVerified;
        if (emailVerified) {
            this.isActive = true;
        }
    }


    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean authenticate(String password) {
        return verifyPassword(password);
    }

    private boolean verifyPassword(String password) {
        return password.equals(this.hashedPassword);
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void promoteToAdmin() {
        this.isAdmin = true;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(String deviceId) {
        devices.removeIf(device -> device.getDeviceId().equals(deviceId));
    }

    public List<Device> getDevices() {
        return devices;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
