package com.samsteenmans.weatherapplication.api;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class CreateRequest {
    /*** Variables ***/
    private final String apiKey = "983a3c889a4f41cda48141850220801";
    private final String BASE_URL_FORECAST = "http://api.weatherapi.com/v1/forecast.json?";
    private final String BASE_URL_SEARCH = "http://api.weatherapi.com/v1/search.json?";


    /*** Constructor ***/
    public CreateRequest() {
        // Nothing
    }

    // Formbody for getting number days of weather
    public Request weatherData(String placeName, int numberOfDays) {
        // Creating the formbody
        RequestBody formBody = new FormBody.Builder()
                .add("key", apiKey)
                .add("q", placeName)
                .add("days", numberOfDays + "")
                .add("aqi", "no")
                .add("alerts", "no")
                .build();

        // Creating the request
        Request request = new Request.Builder()
                .url(BASE_URL_FORECAST)
                .post(formBody)
                .build();

        return request;
    }

    public Request autocomplete(String placeName) {
        // Creating the formbody
        RequestBody formBody = new FormBody.Builder()
                .add("key", apiKey)
                .add("q", placeName)
                .build();

        // Creating the request
        Request request = new Request.Builder()
                .url(BASE_URL_SEARCH)
                .post(formBody)
                .build();

        return request;
    }


}
