package com.samsteenmans.weatherapplication.data.forecast;

import com.samsteenmans.weatherapplication.display.DisplayElement;

import java.util.List;

public class ForecastDay implements DisplayElement {
    /*** Variables ***/
    // Date
    private String date;
    // Day
    private Day day;
    // Astro
    private Astro astro;
    // Hours List of 24 hours
    private List<Hour> hours;

    /*** Constructor ***/
    public ForecastDay(String date, Day day, Astro astro, List<Hour> hours) {
        this.date = date;
        this.day = day;
        this.astro = astro;
        this.hours = hours;
    }

    /*** ToString ***/
    @Override
    public String toString() {
        return "ForeCastDay{" +
                "date='" + date + '\'' +
                ", day=" + day +
                ", astro=" + astro +
                ", hours=" + hours +
                '}';
    }

    /*** Display ***/
    @Override
    public void display() {
        toString();
    }
}
