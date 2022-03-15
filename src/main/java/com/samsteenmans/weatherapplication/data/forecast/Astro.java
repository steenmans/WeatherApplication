package com.samsteenmans.weatherapplication.data.forecast;


import com.samsteenmans.weatherapplication.display.DisplayElement;

public class Astro implements DisplayElement {
    /*** Variables ***/
    // Sun
    private String sunrise,sunset;
    // Moon
    private String moonrise,moonset;

    /*** Constructor ***/
    public Astro(String sunrise, String sunset, String moonrise, String moonset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
    }

    /*** Getters and Setters ***/
    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    /*** toString ***/
    @Override
    public String toString() {
        return "Astro{" +
                "sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", moonrise='" + moonrise + '\'' +
                ", moonset='" + moonset + '\'' +
                '}';
    }

    /*** Display ***/
    @Override
    public void display() {
        toString();
    }
}
