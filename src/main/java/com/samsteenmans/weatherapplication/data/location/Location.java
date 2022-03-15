package com.samsteenmans.weatherapplication.data.location;

public class Location {
    // Variables
    private String name;
    private String country;
    private String localTime;

    // Constructor
    public Location(String name, String country, String localTime) {
        this.name = name;
        this.country = country;
        this.localTime = localTime;
    }

    // Getters + Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }
}
