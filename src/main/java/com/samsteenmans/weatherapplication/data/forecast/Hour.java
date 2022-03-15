package com.samsteenmans.weatherapplication.data.forecast;


import com.samsteenmans.weatherapplication.display.DisplayElement;

public class Hour implements DisplayElement {
    /*** Variables ***/
    // Time
    private String time;
    // Temp celsius
    private double temp_c;
    // Temp fahrenheit
    private double temp_f;
    // Weather condition text
    private String condition;
    // Wind kmh
    private double wind_kph;
    // Wind mph
    private double wind_mph;
    // Wind
    private int windDegree;
    private String windDirection;
    // Pressure millibars
    private double pressure_mb;
    // Humidity
    private int humidity;
    // Changes of forecasts
    private int changeOfRain;

    /*** Constructor ***/
    public Hour(String time, double temp_c, double temp_f, String condition, double wind_kph, double wind_mph, int windDegree, String windDirection, double pressure_mb, int humidity, int changeOfRain) {
        this.time = time;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.condition = condition;
        this.wind_kph = wind_kph;
        this.wind_mph = wind_mph;
        this.windDegree = windDegree;
        this.windDirection = windDirection;
        this.pressure_mb = pressure_mb;
        this.humidity = humidity;
        this.changeOfRain = changeOfRain;
    }

    /*** toString ***/
    @Override
    public String toString() {
        return "Hour{" +
                "time='" + time + '\'' +
                ", temp_c=" + temp_c +
                ", temp_f=" + temp_f +
                ", condition='" + condition + '\'' +
                ", wind_kph=" + wind_kph +
                ", wind_mph=" + wind_mph +
                ", windDegree=" + windDegree +
                ", windDirection='" + windDirection + '\'' +
                ", pressure_mb=" + pressure_mb +
                ", humidity=" + humidity +
                ", changeOfRain=" + changeOfRain +
                '}';
    }

    /*** Display ***/
    @Override
    public void display() {
        toString();
    }
}
