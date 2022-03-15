package com.samsteenmans.weatherapplication.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json {


    /*** Constructor ***/
    public Json() {
        //Nothing
    }

    // JsonObject From String
    public JSONObject jsonObjectFromString(String key){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
             jsonObject = (JSONObject) jsonParser.parse(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    // JsonArray From String
    public JSONArray jsonArrayFromString(String key){
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = (JSONArray) jsonParser.parse(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

    // jsonArray From JsonObject
    public JSONArray jsonArrayFromJsonObject(JSONObject jsonObject, String key){
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonObject.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

    // JsonObject from JsonObject
    public JSONObject jsonObjectFromJsonObject(JSONObject jsonObject, String key){
        JSONObject jsonObjectReturn = null;
        try {
            jsonObjectReturn = (JSONObject) jsonObject.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObjectReturn;
    }


}
