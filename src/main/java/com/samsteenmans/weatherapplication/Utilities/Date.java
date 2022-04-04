package com.samsteenmans.weatherapplication.Utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class Date {
    // Day of Week as a Number
    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    // Day of Week as Text
    public static String getDayStringNew(LocalDate date) {
        return numberToDay(getDayNumberNew(date));
    }

    // Number to day of the week
    // 1 = monday, 7 is sunday
    public static String numberToDay(int number) {
        String dayOfTheWeek = "";

        switch (number) {
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
                break;
            case 7:
                dayOfTheWeek = "Sunday";
            default:
                dayOfTheWeek = "Wrong";
        }
        return dayOfTheWeek;
    }
}
