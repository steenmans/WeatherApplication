package com.samsteenmans.weatherapplication.api;

import okhttp3.*;

public class Get {
    /*** Variables ***/
    private OkHttpClient client = new OkHttpClient();

    /*** Constructor ***/
    public Get() {
        //Nothing
    }

    /*** Send The Request and return String ***/
    public String sendRequest(Request request) {
        String response = "";
        try (ResponseBody responseBody = client.newCall(request).execute().body()) {
            response = responseBody.string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
