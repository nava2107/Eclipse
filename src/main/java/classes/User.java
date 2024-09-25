package classes;
import java.util.ArrayList;
import java.util.List;


public class User {
    private int userId;
    private String username;
    private String email;
    private String hashedPassword;
    private boolean isActive;
    private boolean isAuthenticated;
    private boolean isAdmin;
    private List<Device> devices;

    public User(int userId, String username, String email, String hashedPassword) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.isActive = true;
        this.isAuthenticated = false;
        this.isAdmin = false;
        this.devices = new ArrayList<>();
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

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
