package classes;
import java.util.ArrayList;
import java.util.List;


public class User {

    // userCount brukes for å telle antall ganger et User-objekt har blitt opprettet,
    // og skal brukes til å fordele userId.
    private static int userCount = 0;

    // userId for å få en unik identifikator av brukere
    private int userId;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String hashedPassword;

    private boolean isActive;

    // isAuthenticated viser om brukeren er autentisert eller ikke
    private boolean isAuthenticated;

    // isEmailVerified sjekker om mailen til user er verifisert
    private boolean isEmailVerified;

    // isAdmin viser om brukeren har admin-rettigheter eller ikke, for å finne ut av hva de kan/kan ikke gjøre
    private boolean isAdmin;

    // devices er en liste med devices som er relatert til brukeren
    private ArrayList<Device> devices;


    // Konstruktør som lager user-objekter
    public User(int userCount, String username, String firstName, String lastName, String email, String hashedPassword) {
        this.userId = ++userCount;
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

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.isEmailVerified = emailVerified;
        if (emailVerified) {
            this.isActive = true;
        }
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

    public static int getUserCount() {
        return userCount;
    }

    public static void setUserCount(int userCount) {
        User.userCount = userCount;
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
