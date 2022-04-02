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

    /*** Getters and Setters ***/
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }
}
