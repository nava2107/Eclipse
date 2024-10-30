package com.example.application.classes.Devices.environment;

public class AirQuality extends Environment {

    //noen forskjellige luftkvalitetsmålere
    private double co2Level;
    private double pm25Level; //PM2.5 nivå i µg/m³, små partikler som kan påvirke helsen
    private double pm10Level; // PM10 nivå i µg/m³, større partikler som indikerer luftforurensning
    private double temperature;
    private double humidity;
    private double tvocLevel; //Total Volatile Organic Compounds
    private int airQualityIndex; //oppsummerer den totale luftkvaliteten

    public AirQuality(Long deviceId, String deviceName, String deviceBrand, int updateInterval,
                      double co2Level, double pm25Level, double pm10Level,
                      double temperature, double humidity, double tvocLevel, int airQualityIndex) {
        super(deviceId, deviceName, deviceBrand, updateInterval);
        this.co2Level = co2Level;
        this.pm25Level = pm25Level;
        this.pm10Level = pm10Level;
        this.temperature = temperature;
        this.humidity = humidity;
        this.tvocLevel = tvocLevel;
        this.airQualityIndex = airQualityIndex;
    }

    @Override
    public void performMeasurement() {
        updateLastUpdateTime();
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() +
                "\nType: Air Quality Sensor" +
                "\nCO2 Level: " + co2Level + " ppm" +
                "\nPM2.5 Level: " + pm25Level + " µg/m³" +
                "\nPM10 Level: " + pm10Level + " µg/m³" +
                "\nTemperature: " + temperature + " °C" +
                "\nHumidity: " + humidity + " %" +
                "\nTVOC Level: " + tvocLevel + " ppb" +
                "\nAir Quality Index: " + airQualityIndex;
    }

    public double getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(double co2Level) {
        this.co2Level = co2Level;
    }

    public double getPm25Level() {
        return pm25Level;
    }

    public void setPm25Level(double pm25Level) {
        this.pm25Level = pm25Level;
    }

    public double getPm10Level() {
        return pm10Level;
    }

    public void setPm10Level(double pm10Level) {
        this.pm10Level = pm10Level;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTvocLevel() {
        return tvocLevel;
    }

    public void setTvocLevel(double tvocLevel) {
        this.tvocLevel = tvocLevel;
    }

    public int getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(int airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

}
