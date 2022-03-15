package com.samsteenmans.weatherapplication;

import com.samsteenmans.weatherapplication.data.Data;
import com.samsteenmans.weatherapplication.weatherData.WeatherData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainScreenController {
    /* *** --------- ***
    // *** Variables ***
    // *** --------- ***/
    @FXML // fx:id="areaChart"
    private AreaChart<?, ?> areaChart; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionImageViewIcon"
    private ImageView currentConditionImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelPressure"
    private Label currentConditionLabelPressure; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelRain"
    private Label currentConditionLabelRain; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelState"
    private Label currentConditionLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelTemperature"
    private Label currentConditionLabelTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelWind"
    private Label currentConditionLabelWind; // Value injected by FXMLLoader

    @FXML // fx:id="fifthBlockImageViewIcon"
    private ImageView fifthBlockImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="fifthBlockLabelDay"
    private Label fifthBlockLabelDay; // Value injected by FXMLLoader

    @FXML // fx:id="fifthBlockLabelMaxTemperature"
    private Label fifthBlockLabelMaxTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="fifthBlockLabelMinTemperature"
    private Label fifthBlockLabelMinTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="fifthBlockLabelState"
    private Label fifthBlockLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="firstBlockImageViewIcon"
    private ImageView firstBlockImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="firstBlockLabelMaxTemperature"
    private Label firstBlockLabelMaxTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="firstBlockLabelMinTemperature"
    private Label firstBlockLabelMinTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="firstBlockLabelState"
    private Label firstBlockLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="firstBlockVBox"
    private VBox firstBlockVBox; // Value injected by FXMLLoader

    @FXML // fx:id="fourthBlockImageViewIcon"
    private ImageView fourthBlockImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="fourthBlockLabelDay"
    private Label fourthBlockLabelDay; // Value injected by FXMLLoader

    @FXML // fx:id="fourthBlockLabelState"
    private Label fourthBlockLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="fourthBlockMaxTemperature"
    private Label fourthBlockMaxTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="fourthBlockMinTemperature"
    private Label fourthBlockMinTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockImageViewIcon"
    private ImageView secondBlockImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockLabelDay"
    private Label secondBlockLabelDay; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockLabelMaxTemperature"
    private Label secondBlockLabelMaxTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockLabelMinTemperature"
    private Label secondBlockLabelMinTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockLabelState"
    private Label secondBlockLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockVBox"
    private VBox secondBlockVBox; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldSearch"
    private TextField textFieldSearch; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockImageViewIcon"
    private ImageView thirdBlockImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockLabelDay"
    private Label thirdBlockLabelDay; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockLabelMaxTemperature"
    private Label thirdBlockLabelMaxTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockLabelMinTemperature"
    private Label thirdBlockLabelMinTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockLabelState"
    private Label thirdBlockLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockVBox"
    private VBox thirdBlockVBox; // Value injected by FXMLLoader

    // TEST main
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Data data = new Data();
    }

    public void initialize(){
        WeatherData weatherData = new WeatherData();
        Data data = new Data();
        weatherData.setMeasurements(data.getCompleteWeatherData("duffel",5));

        // Add a listener to the Search textField for giving autocomplete
        textFieldSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                data.getAutocomplete(newValue);
            }
        });
    }



}