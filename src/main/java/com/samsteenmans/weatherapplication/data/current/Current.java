package com.samsteenmans.weatherapplication.data.current;


import com.samsteenmans.weatherapplication.display.DisplayElement;

public class Current implements DisplayElement {
    /*** Variables ***/
    // Temperature
    private double temp_c,temp_f;
    // Wind
    private double wind_kph;
    private String wind_dir;
    // Pressure + humidity
    private double pressure_mb; // Millibar
    private double humidity;
    // Condition
    private String conditionText; // Text
    private long conditionCode; // Code

    // Constructor
    public Current(double temp_c, double temp_f, double wind_kph, String wind_dir, double pressure_mb, double humidity, String condition,long conditionCode) {
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.wind_kph = wind_kph;
        this.wind_dir = wind_dir;
        this.pressure_mb = pressure_mb;
        this.humidity = humidity;
        this.conditionText = condition;
        this.conditionCode = conditionCode;
    }

    // To String
    @Override
    public String toString() {
        return "Current{" +
                "temp_c=" + temp_c +
                ", temp_f=" + temp_f +
                ", wind_kph=" + wind_kph +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure_mb=" + pressure_mb +
                ", humidity=" + humidity +
                ", condition='" + conditionText + '\'' +
                '}';
    }

    // DisplayElement
    @Override
    public void display() {
        toString();
    }

    // Getters + Setters
    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public long getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(long conditionCode) {
        this.conditionCode = conditionCode;
    }
}
