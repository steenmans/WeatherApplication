package com.samsteenmans.weatherapplication;

import com.samsteenmans.weatherapplication.GuiFacility.Symbol;
import com.samsteenmans.weatherapplication.data.CompleteWeatherData;
import com.samsteenmans.weatherapplication.data.Data;
import com.samsteenmans.weatherapplication.data.autocomplete.AutoCompleteLocations;
import com.samsteenmans.weatherapplication.data.current.Current;
import com.samsteenmans.weatherapplication.data.forecast.ForecastDay;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

import java.io.File;
import java.util.List;

public class MainScreenController {
    /* *** --------- ***
    // *** Variables ***
    // *** --------- ***/
    @FXML // fx:id="textFieldSearch"
    private TextField textFieldSearch; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionImageViewIcon"
    private ImageView currentConditionImageViewIcon; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelState"
    private Label currentConditionLabelState; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelTemperature"
    private Label currentConditionLabelTemperature; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelPressure"
    private Label currentConditionLabelPressure; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelRain"
    private Label currentConditionLabelRain; // Value injected by FXMLLoader

    @FXML // fx:id="currentConditionLabelWind"
    private Label currentConditionLabelWind; // Value injected by FXMLLoader

    @FXML // fx:id="blockVBox1"
    private VBox blockVBox1; // Value injected by FXMLLoader

    @FXML // fx:id="LabelDay1"
    private Label labelDay1; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewIcon1"
    private ImageView imageViewIcon1; // Value injected by FXMLLoader

    @FXML // fx:id="labelState1"
    private Label labelState1; // Value injected by FXMLLoader

    @FXML // fx:id="labelMaxTemperature1"
    private Label labelMaxTemperature1; // Value injected by FXMLLoader

    @FXML // fx:id="labelMinTemperature1"
    private Label labelMinTemperature1; // Value injected by FXMLLoader

    @FXML // fx:id="secondBlockVBox"
    private VBox secondBlockVBox; // Value injected by FXMLLoader

    @FXML // fx:id="LabelDay2"
    private Label labelDay2; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewIcon2"
    private ImageView imageViewIcon2; // Value injected by FXMLLoader

    @FXML // fx:id="labelState2"
    private Label labelState2; // Value injected by FXMLLoader

    @FXML // fx:id="labelMaxTemperature2"
    private Label labelMaxTemperature2; // Value injected by FXMLLoader

    @FXML // fx:id="labelMinTemperature2"
    private Label labelMinTemperature2; // Value injected by FXMLLoader

    @FXML // fx:id="thirdBlockVBox"
    private VBox thirdBlockVBox; // Value injected by FXMLLoader

    @FXML // fx:id="LabelDay3"
    private Label labelDay3; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewIcon3"
    private ImageView imageViewIcon3; // Value injected by FXMLLoader

    @FXML // fx:id="labelState3"
    private Label labelState3; // Value injected by FXMLLoader

    @FXML // fx:id="labelMaxTemperature3"
    private Label labelMaxTemperature3; // Value injected by FXMLLoader

    @FXML // fx:id="labelMinTemperature3"
    private Label labelMinTemperature3; // Value injected by FXMLLoader

    @FXML // fx:id="LabelDay4"
    private Label labelDay4; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewIcon4"
    private ImageView imageViewIcon4; // Value injected by FXMLLoader

    @FXML // fx:id="labelState4"
    private Label labelState4; // Value injected by FXMLLoader

    @FXML // fx:id="labelMaxTemperature4"
    private Label labelMaxTemperature4; // Value injected by FXMLLoader

    @FXML // fx:id="labelMinTemperature4"
    private Label labelMinTemperature4; // Value injected by FXMLLoader

    @FXML // fx:id="labelDay5"
    private Label labelDay5; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewIcon5"
    private ImageView imageViewIcon5; // Value injected by FXMLLoader

    @FXML // fx:id="labelState5"
    private Label labelState5; // Value injected by FXMLLoader

    @FXML // fx:id="labelMaxTemperature5"
    private Label labelMaxTemperature5; // Value injected by FXMLLoader

    @FXML // fx:id="labelMinTemperature5"
    private Label labelMinTemperature5; // Value injected by FXMLLoader

    @FXML // fx:id="areaChart"
    private AreaChart<?, ?> areaChart; // Value injected by FXMLLoader


    /* *** --------- ***
    // *** Initialize ***
    // *** --------- ***/
    public void initialize() {
        // Variables
        Data data = new Data();


        // Add a listener to the Search textField for giving autocomplete
        textFieldSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {    // Check if empty
                // Get the AutoComplete results
                List<AutoCompleteLocations> autoCompleteLocationsList = data.getAutocomplete(newValue);
                String[] autocompleteStringList = new String[autoCompleteLocationsList.size()];

                // Loop through the autocomplete results
                for (int i = 0; i < autoCompleteLocationsList.size(); i++) {
                    AutoCompleteLocations autoCompleteLocationsTemp = autoCompleteLocationsList.get(i);
                    autocompleteStringList[i] = autoCompleteLocationsTemp.getName();
                }

                // Bind it to the textField
                TextFields.bindAutoCompletion(textFieldSearch, autocompleteStringList);
            }
        });

        // Listener if entered is pressed in the textField
        textFieldSearch.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                setFxmlData(data.getCompleteWeatherData(textFieldSearch.getText(), 5));
            }
        });
    }


    /* *** --------- ***
    // *** Gui ***
    // *** --------- ***/

    // Change the fxml data with CompleteData
    public void setFxmlData(CompleteWeatherData completeWeatherData) {
        // Current Conditions
        changeCurrentConditionsGui(completeWeatherData.getCurrent());
        // Today day 1
        changeTodayDay1(completeWeatherData.getForecastDayList().get(0));
        // Day 2
        changeTodayDay2(completeWeatherData.getForecastDayList().get(1));
        // Day 3
        changeTodayDay3(completeWeatherData.getForecastDayList().get(2));
        // Day 4
        //changeTodayDay4(completeWeatherData.getForecastDayList().get(3));
        // Day 5
        //changeTodayDay5(completeWeatherData.getForecastDayList().get(4));


    }

    // Change Current Conditions
    public void changeCurrentConditionsGui(Current current) {
        // Current Day
        currentConditionLabelTemperature.setText(String.valueOf(current.getTemp_c())); // Current Temp
        currentConditionLabelPressure.setText(String.valueOf(current.getPressure_mb())); // Current pressure
        // currentConditionLabelRain.setText(String.valueOf(current.)); TODO uitzoeken,niet beschikbaar
        currentConditionLabelWind.setText(String.valueOf(current.getWind_kph())); // Current Wind
        currentConditionLabelState.setText(current.getConditionText()); // Current condition
        // Symbol Change
        Symbol symbol = new Symbol();
        String url = symbol.getWeatherSymbolURL(current.getConditionCode());
        try {
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            currentConditionImageViewIcon.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Change Today Day 1
    public void changeTodayDay1(ForecastDay forecastDay) {
        // Day
        // Is always "Today"

        // Symbol
        Symbol symbol = new Symbol();
        String url = symbol.getWeatherSymbolURL(forecastDay.getDay().getConditionCode());
        try {
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            imageViewIcon1.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Status condition
        labelState1.setText(forecastDay.getDay().getConditionText());

        // Max Temperature
        labelMaxTemperature1.setText(forecastDay.getDay().getMaxTemp_c() + " C°");

        // Min Temperature
        labelMinTemperature1.setText(forecastDay.getDay().getMinTemp_c() + " C°");
    }

    // Change Today Day 2
    public void changeTodayDay2(ForecastDay forecastDay) {
        // Day
        // Is always "Today"

        // Symbol
        Symbol symbol = new Symbol();
        String url = symbol.getWeatherSymbolURL(forecastDay.getDay().getConditionCode());
        try {
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            imageViewIcon2.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Status condition
        labelState2.setText(forecastDay.getDay().getConditionText());

        // Max Temperature
        labelMaxTemperature2.setText(forecastDay.getDay().getMaxTemp_c() + " C°");

        // Min Temperature
        labelMinTemperature2.setText(forecastDay.getDay().getMinTemp_c() + " C°");
    }

    // Change Today Day 3
    public void changeTodayDay3(ForecastDay forecastDay) {
        // Day
        // Is always "Today"

        // Symbol
        Symbol symbol = new Symbol();
        String url = symbol.getWeatherSymbolURL(forecastDay.getDay().getConditionCode());
        try {
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            imageViewIcon3.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Status condition
        labelState3.setText(forecastDay.getDay().getConditionText());

        // Max Temperature
        labelMaxTemperature3.setText(forecastDay.getDay().getMaxTemp_c() + " C°");

        // Min Temperature
        labelMinTemperature3.setText(forecastDay.getDay().getMinTemp_c() + " C°");
    }

    // Change Today Day 4
    public void changeTodayDay4(ForecastDay forecastDay) {
        // Day
        // Is always "Today"

        // Symbol
        Symbol symbol = new Symbol();
        String url = symbol.getWeatherSymbolURL(forecastDay.getDay().getConditionCode());
        try {
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            imageViewIcon4.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Status condition
        labelState4.setText(forecastDay.getDay().getConditionText());

        // Max Temperature
        labelMaxTemperature4.setText(forecastDay.getDay().getMaxTemp_c() + " C°");

        // Min Temperature
        labelMinTemperature4.setText(forecastDay.getDay().getMinTemp_c() + " C°");
    }

    // Change Today Day 5
    public void changeTodayDay5(ForecastDay forecastDay) {
        // Day
        // Is always "Today"

        // Symbol
        Symbol symbol = new Symbol();
        String url = symbol.getWeatherSymbolURL(forecastDay.getDay().getConditionCode());
        try {
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            imageViewIcon5.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Status condition
        labelState5.setText(forecastDay.getDay().getConditionText());

        // Max Temperature
        labelMaxTemperature5.setText(forecastDay.getDay().getMaxTemp_c() + " C°");

        // Min Temperature
        labelMinTemperature5.setText(forecastDay.getDay().getMinTemp_c() + " C°");
    }


}