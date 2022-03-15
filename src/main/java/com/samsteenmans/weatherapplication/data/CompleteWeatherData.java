package com.samsteenmans.weatherapplication.data;



import com.samsteenmans.weatherapplication.data.current.Current;
import com.samsteenmans.weatherapplication.data.forecast.ForecastDay;
import com.samsteenmans.weatherapplication.data.location.Location;

import java.util.List;


public class CompleteWeatherData {
    // Variables
    private Location location;
    private Current current;
    private List<ForecastDay> forecastDayList;

    // Constructor
    public CompleteWeatherData(Location location, Current current, List<ForecastDay> forecastDayList) {
        this.location = location;
        this.current = current;
        this.forecastDayList = forecastDayList;
    }

    // Getters and Setters
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<ForecastDay> getForecastDayList() {
        return forecastDayList;
    }

    public void setForecastDayList(List<ForecastDay> forecastDayList) {
        this.forecastDayList = forecastDayList;
    }
}
