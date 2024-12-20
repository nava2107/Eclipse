package com.example.application.classes.Devices.Security;

public class Lock extends Security {

    private int lockCode;
    private int failedAttempts;
    private final int MAX_ATTEMPTS = 3;


    public Lock(Long deviceId, String deviceName, String deviceBrand, int lockCode) {
        super(deviceId, deviceName, deviceBrand);
        this.lockCode = lockCode;
        this.failedAttempts = 0;
    }

    public void unlock(int code) {
        if (code == lockCode) {
            System.out.println("The lock has been successfully unlocked.");
            failedAttempts = 0;
        } else {
            failedAttempts++;
            System.out.println("Incorrect code. Attempt " + failedAttempts + " of " + MAX_ATTEMPTS + ".");
            checkFailedAttempts();
        }
    }

    private void checkFailedAttempts() {
        if (failedAttempts >= MAX_ATTEMPTS) {
            System.out.println("Warning: Multiple failed attempts detected! Lock may be compromised.");
        }
    }

    private void setNewLockCode(int newLockCode) {
        if (newLockCode != lockCode){
            this.lockCode = newLockCode;
            System.out.println("The code for the lock has been successfully changed.");
        }
    }

    @Override
    public void activate() {
        super.setActive(true);
        System.out.println("Lock activated.");
    }

    @Override
    public void deactivate() {
        super.setActive(false);
        System.out.println("Lock deactivated.");
    }
}
