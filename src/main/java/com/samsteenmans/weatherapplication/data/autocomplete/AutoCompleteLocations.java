package com.samsteenmans.weatherapplication.data.autocomplete;

public class AutoCompleteLocations {
    // Variables
    private int id;
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String url;

    // Constructor
    public AutoCompleteLocations(int id, String name, String region, String country, double lat, double lon, String url) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.url = url;
    }

    // ToString
    @Override
    public String toString() {
        return "AutoCompleteLocations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", url='" + url + '\'' +
                '}';
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
