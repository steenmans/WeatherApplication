package com.samsteenmans.weatherapplication.data.forecast;


import com.samsteenmans.weatherapplication.display.DisplayElement;

public class Day implements DisplayElement {
    /* This is the forecast of the full day
    Inclusion all the averages
     */

    /*** Variables ***/
    // Temperature celsius
    private double maxTemp_c, minTemp_c, avgTemp_c;
    // Temperature fahrenheit
    private double maxTemp_f, minTemp_f, avgTemp_f;
    // Wind kph
    private double maxWind_kph;
    // Wind mph
    private double maxWind_mph;
    // Humidity
    private double avgHumidity;
    // Changes of forecasts
    private int dailyChanceOfRain;
    // Weather condition text
    private String condition;

    /*** Constructor ***/
    public Day(double maxTemp_c, double minTemp_c, double avgTemp_c, double maxTemp_f, double minTemp_f, double avgTemp_f, double maxWind_kph, double maxWind_mph, double avgHumidity, int dailyChanceOfRain, String condition) {
        this.maxTemp_c = maxTemp_c;
        this.minTemp_c = minTemp_c;
        this.avgTemp_c = avgTemp_c;
        this.maxTemp_f = maxTemp_f;
        this.minTemp_f = minTemp_f;
        this.avgTemp_f = avgTemp_f;
        this.maxWind_kph = maxWind_kph;
        this.maxWind_mph = maxWind_mph;
        this.avgHumidity = avgHumidity;
        this.dailyChanceOfRain = dailyChanceOfRain;
        this.condition = condition;
    }

    /*** Getters and Setters ***/
    public double getMaxTemp_c() {
        return maxTemp_c;
    }

    public void setMaxTemp_c(double maxTemp_c) {
        this.maxTemp_c = maxTemp_c;
    }

    public double getMinTemp_c() {
        return minTemp_c;
    }

    public void setMinTemp_c(double minTemp_c) {
        this.minTemp_c = minTemp_c;
    }

    public double getAvgTemp_c() {
        return avgTemp_c;
    }

    public void setAvgTemp_c(double avgTemp_c) {
        this.avgTemp_c = avgTemp_c;
    }

    public double getMaxTemp_f() {
        return maxTemp_f;
    }

    public void setMaxTemp_f(double maxTemp_f) {
        this.maxTemp_f = maxTemp_f;
    }

    public double getMinTemp_f() {
        return minTemp_f;
    }

    public void setMinTemp_f(double minTemp_f) {
        this.minTemp_f = minTemp_f;
    }

    public double getAvgTemp_f() {
        return avgTemp_f;
    }

    public void setAvgTemp_f(double avgTemp_f) {
        this.avgTemp_f = avgTemp_f;
    }

    public double getMaxWind_kph() {
        return maxWind_kph;
    }

    public void setMaxWind_kph(double maxWind_kph) {
        this.maxWind_kph = maxWind_kph;
    }

    public double getMaxWind_mph() {
        return maxWind_mph;
    }

    public void setMaxWind_mph(double maxWind_mph) {
        this.maxWind_mph = maxWind_mph;
    }

    public double getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(double avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public int getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setDailyChanceOfRain(int dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    /*** toString ***/
    @Override
    public String toString() {
        return "Day{" +
                "maxTemp_c=" + maxTemp_c +
                ", minTemp_c=" + minTemp_c +
                ", avgTemp_c=" + avgTemp_c +
                ", maxTemp_f=" + maxTemp_f +
                ", minTemp_f=" + minTemp_f +
                ", avgTemp_f=" + avgTemp_f +
                ", maxWind_kph=" + maxWind_kph +
                ", maxWind_mph=" + maxWind_mph +
                ", avgHumidity=" + avgHumidity +
                ", dailyChanceOfRain=" + dailyChanceOfRain +
                ", condition='" + condition + '\'' +
                '}';
    }

    /*** Display ***/
    @Override
    public void display() {
        toString();
    }
}

