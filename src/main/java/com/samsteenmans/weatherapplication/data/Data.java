package com.samsteenmans.weatherapplication.data;


import com.samsteenmans.weatherapplication.Json.Json;
import com.samsteenmans.weatherapplication.api.CreateRequest;
import com.samsteenmans.weatherapplication.api.Get;
import com.samsteenmans.weatherapplication.data.autocomplete.AutoCompleteLocations;
import com.samsteenmans.weatherapplication.data.current.Current;
import com.samsteenmans.weatherapplication.data.forecast.Astro;
import com.samsteenmans.weatherapplication.data.forecast.Day;
import com.samsteenmans.weatherapplication.data.forecast.ForecastDay;
import com.samsteenmans.weatherapplication.data.forecast.Hour;
import com.samsteenmans.weatherapplication.data.location.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Data {
    /*
    This class is to get al the data control from 1 simple place
     */

    // TODO check the http code , 200 is valid
    // Get all the weather Data of the chosen days, return as CompleteWeatherData
    public CompleteWeatherData getCompleteWeatherData(String cityName, int numberOfDays) {
        /*** Variables ***/
        // Request
        CreateRequest createRequest = new CreateRequest();
        Get get = new Get();
        // Json
        Json json = new Json();
        // Data
        Location location = null;
        Current current = null;
        CompleteWeatherData completeWeatherData = null;
        //Lists
        List<ForecastDay> forecastDayList = new ArrayList<>();

        /*** Request ***/
        // Send the request through the api and return a String
        String response = get.sendRequest(createRequest.weatherData(cityName, numberOfDays));

        // Make a Json object from the Response String
        JSONObject jsonObjectResponse = json.jsonObjectFromString(response);

        // Take the object "location","current","forecast" from the object jsonObjectResponse
        JSONObject jsonObjectLocation = json.jsonObjectFromJsonObject(jsonObjectResponse, "location");
        JSONObject jsonObjectCurrent = json.jsonObjectFromJsonObject(jsonObjectResponse, "current");
        JSONObject jsonObjectForecast = json.jsonObjectFromJsonObject(jsonObjectResponse, "forecast");


        /*** Location ***/
        String name = (String) jsonObjectLocation.get("name");
        String country = (String) jsonObjectLocation.get("country");
        String localTime = (String) jsonObjectLocation.get("localtime");
        // Create location
        location = new Location(name, country, localTime);

        /*** Current ***/
        double currentTemp_c = Double.parseDouble(jsonObjectCurrent.get("temp_c").toString());
        double currentTemp_f = Double.parseDouble(jsonObjectCurrent.get("temp_f").toString());
        double currentWind_kph = Double.parseDouble(jsonObjectCurrent.get("wind_kph").toString());
        String currentWind_dir = (String) jsonObjectCurrent.get("wind_dir");
        double currentPressure_mb = Double.parseDouble(jsonObjectCurrent.get("pressure_mb").toString());
        double currentHumidity = Double.parseDouble(jsonObjectCurrent.get("humidity").toString());

        // Get the condition object from current object
        JSONObject jsonObjectCondition = json.jsonObjectFromJsonObject(jsonObjectCurrent, "condition");
        String currentConditionText = (String) jsonObjectCondition.get("text");
        Long currentConditionCode = (Long) jsonObjectCondition.get("code");

        // Create current
        current = new Current(currentTemp_c, currentTemp_f, currentWind_kph, currentWind_dir, currentPressure_mb, currentHumidity, currentConditionText, currentConditionCode);
        System.out.println(current);

        /*** Get data from ForecastDay ***/
        // Get the jsonArray "forecastday" from the object jsonObjectForecast
        JSONArray jsonArrayForecastday = json.jsonArrayFromJsonObject(jsonObjectForecast, "forecastday");

        // Go through the jsonArray "forecastday"
        // Go trough every day
        // In every day(array) there are
        // date
        // day(Object)
        // astro(Object)
        // Hour (array)
        for (int i = 0; i < jsonArrayForecastday.size(); i++) { // Go through forecastsDay
            // Create an JsonObject from every "forecastday"
            JSONObject jsonObjectForecastDay = (JSONObject) jsonArrayForecastday.get(i);

            // Objects Needed
            Day day;
            Astro astro;
            List<Hour> hourList = new ArrayList<>();

            // Get date
            String date = (String) jsonObjectForecastDay.get("date");

            // Get day object
            JSONObject jsonObjectDay = (JSONObject) jsonObjectForecastDay.get("day");

            // Get astro object
            JSONObject jsonObjectAstro = (JSONObject) jsonObjectForecastDay.get("astro");

            // Get hour array
            JSONArray jsonArrayHour = (JSONArray) jsonObjectForecastDay.get("hour");


            /*** Get data from day ***/
            // Temperature
            double maxTemp_c = Double.parseDouble(jsonObjectDay.get("maxtemp_c").toString());
            double minTemp_c = Double.parseDouble(jsonObjectDay.get("mintemp_c").toString());
            double avgTemp_c = Double.parseDouble(jsonObjectDay.get("avgtemp_c").toString());
            double maxTemp_f = Double.parseDouble(jsonObjectDay.get("maxtemp_f").toString());
            double minTemp_f = Double.parseDouble(jsonObjectDay.get("maxtemp_f").toString());
            double avgTemp_f = Double.parseDouble(jsonObjectDay.get("maxtemp_f").toString());
            // Wind
            double maxWind_kph = Double.parseDouble(jsonObjectDay.get("maxwind_kph").toString());
            double maxWind_mph = Double.parseDouble(jsonObjectDay.get("maxwind_mph").toString());
            // Humidity
            Double avgHumidity = Double.parseDouble(jsonObjectDay.get("avghumidity").toString());
            // Changes of forecasts
            int dailyChanceOfRain = Integer.parseInt(jsonObjectDay.get("daily_chance_of_rain").toString());
            // Weather condition text
            // Get object condition
            JSONObject jsonObjectDayCondition = (JSONObject) jsonObjectDay.get("condition");
            String conditionText = (String) jsonObjectDayCondition.get("text");
            Long conditionCode = (Long) jsonObjectDayCondition.get("code");
            // Create Day
            day = new Day(maxTemp_c, minTemp_c, avgTemp_c, maxTemp_f, minTemp_f, avgTemp_f, maxWind_kph, maxWind_mph,
                    avgHumidity, dailyChanceOfRain, conditionText, conditionCode);


            /*** Get data from astro ***/
            // Sun
            String sunrise = (String) jsonObjectAstro.get("sunrise");
            String sunset = (String) jsonObjectAstro.get("sunset");
            // Moon
            String moonrise = (String) jsonObjectAstro.get("moonrise");
            String moonset = (String) jsonObjectAstro.get("moonset");
            // Create Astro
            astro = new Astro(sunrise, sunset, moonrise, moonset);


            /*** Get data from hour ***/
            for (int j = 0; j < jsonArrayHour.size(); j++) { // Go through Hour
                // Create an JsonObject from every "hour"
                JSONObject jsonObjectHour = (JSONObject) jsonArrayHour.get(j);

                // Time
                String time = (String) jsonObjectHour.get("time");
                // Temperature
                double hourTemp_c = Double.parseDouble(jsonObjectHour.get("temp_c").toString());
                double hourTemp_f = Double.parseDouble(jsonObjectHour.get("temp_f").toString());
                // Weather condition text
                // Get object condition
                JSONObject jsonObjectHourCondition = (JSONObject) jsonObjectHour.get("condition");
                String hourCondition = (String) jsonObjectHourCondition.get("text");
                // Wind
                double hourWind_kph = Double.parseDouble(jsonObjectHour.get("wind_kph").toString());
                double hourWind_mph = Double.parseDouble(jsonObjectHour.get("wind_mph").toString());
                int hourWindDegree = Integer.parseInt(jsonObjectHour.get("wind_degree").toString());
                String hourWindDirection = (String) jsonObjectHourCondition.get("wind_dir");
                // Pressure and humidity
                double hourPressure_mb = Double.parseDouble(jsonObjectHour.get("pressure_mb").toString());
                int hourHumidity = Integer.parseInt(jsonObjectHour.get("humidity").toString());
                // Changes of forecasts
                int hourChangeOfRain = Integer.parseInt(jsonObjectHour.get("chance_of_rain").toString());

                // Create hour object
                Hour hour = new Hour(time, hourTemp_c, hourTemp_f, hourCondition, hourWind_kph,
                        hourWind_mph, hourWindDegree, hourWindDirection, hourPressure_mb, hourHumidity, hourChangeOfRain);
                // Add to the list
                hourList.add(hour);
            }


            /*** Add to the list of forecastDay ***/
            forecastDayList.add(new ForecastDay(date, day, astro, hourList));
        }

        /*** Send everything back so Weather data can update ***/
        completeWeatherData = new CompleteWeatherData(location, current, forecastDayList);
        return completeWeatherData;
    }

    // TODO check the http code, 200 is valid
    // Get the autocomplete data, return as a String[]
    public List<AutoCompleteLocations> getAutocomplete(String cityName) {
        /*** Variables ***/
        // Request
        CreateRequest createRequest = new CreateRequest();
        Get get = new Get();
        // Json
        Json json = new Json();
        //Lists
        List<AutoCompleteLocations> autoCompleteLocationsList = new ArrayList<>();


        // Send the request through the api and return a String
        String response = get.sendRequest(createRequest.autocomplete(cityName));

        // Make a Json object from the Response String
        JSONArray jsonArrayResponse = json.jsonArrayFromString(response);

        // Go through jsonArrayResponse
        for (int i = 0; i < jsonArrayResponse.size(); i++) {
            // Create a JsonObject
            JSONObject jsonObject = (JSONObject) jsonArrayResponse.get(i);

            // Take the values out of the jsonObject
            int id = Integer.parseInt(jsonObject.get("id").toString());
            String name = (String) jsonObject.get("name");
            String region = (String) jsonObject.get("region");
            String country = (String) jsonObject.get("country");
            double lat = Double.parseDouble(jsonObject.get("lat").toString());
            double lon = Double.parseDouble(jsonObject.get("lon").toString());
            String url = (String) jsonObject.get("url");

            // Create AutoCompleteLocations
            AutoCompleteLocations autoCompleteLocations = new AutoCompleteLocations(id, name, region, country, lat, lon, url);

            System.out.println(autoCompleteLocations);

            // Put it into the list
            autoCompleteLocationsList.add(autoCompleteLocations);
        }
        return autoCompleteLocationsList;
    }

}
