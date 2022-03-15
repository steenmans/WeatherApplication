package com.samsteenmans.weatherapplication.interfaces;


import com.samsteenmans.weatherapplication.data.CompleteWeatherData;

public interface Observer {
    void update(CompleteWeatherData completeWeatherData);
}
