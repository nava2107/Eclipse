package classes;

public class Device {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private boolean isActive;

    public Device(String deviceId, String deviceName, String deviceType) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.isActive = true;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        this.isActive = false;
    }
}
