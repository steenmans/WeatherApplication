package com.samsteenmans.weatherapplication;

import com.samsteenmans.weatherapplication.GuiFacility.Symbol;
import com.samsteenmans.weatherapplication.data.CompleteWeatherData;
import com.samsteenmans.weatherapplication.data.Data;
import com.samsteenmans.weatherapplication.data.autocomplete.AutoCompleteLocations;
import com.samsteenmans.weatherapplication.data.current.Current;
import com.samsteenmans.weatherapplication.data.forecast.ForecastDay;
import com.samsteenmans.weatherapplication.weatherData.WeatherData;
import javafx.event.EventType;
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

    @FXML // fx:id="areaChart"
    private AreaChart<?, ?> areaChart; // Value injected by FXMLLoader

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

    @FXML // fx:id="secondBlockLabelDay"
    private Label secondBlockLabelDay; // Value injected by FXMLLoader

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

    @FXML // fx:id="thirdBlockLabelDay"
    private Label thirdBlockLabelDay; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewIcon3"
    private ImageView imageViewIcon3; // Value injected by FXMLLoader

    @FXML // fx:id="labelState3"
    private Label labelState3; // Value injected by FXMLLoader

    @FXML // fx:id="labelMaxTemperature3"
    private Label labelMaxTemperature3; // Value injected by FXMLLoader

    @FXML // fx:id="labelMinTemperature3"
    private Label labelMinTemperature3; // Value injected by FXMLLoader

    @FXML // fx:id="blockLabelDay4"
    private Label blockLabelDay4; // Value injected by FXMLLoader

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



    /* *** --------- ***
    // *** Initialize ***
    // *** --------- ***/
    public void initialize(){
        WeatherData weatherData = new WeatherData();
        Data data = new Data();


        // Add a listener to the Search textField for giving autocomplete
        textFieldSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            // TODO Verder uitwerken,werkt eindelijk
            if(!newValue.isEmpty()){    // Check if empty
                List<AutoCompleteLocations> autoCompleteLocationsList = data.getAutocomplete(newValue);

                String[] test = new String[autoCompleteLocationsList.size()];

                for (int i = 0; i <autoCompleteLocationsList.size() ; i++) {
                    AutoCompleteLocations autoCompleteLocationsTemp = autoCompleteLocationsList.get(i);
                    test[i] = autoCompleteLocationsTemp.getName();
                }
                TextFields.bindAutoCompletion(textFieldSearch,test);
            }
        });

        // Listener if entered is pressed in the textField
        textFieldSearch.setOnKeyPressed( event -> {
            if( event.getCode() == KeyCode.ENTER ) {
                setFxmlData(data.getCompleteWeatherData(textFieldSearch.getText(),5));
            }
        } );
    }


    /* *** --------- ***
    // *** Gui ***
    // *** --------- ***/

    // Change the fxml data with CompleteData
    public void setFxmlData(CompleteWeatherData completeWeatherData){
        // Current Day
        changeCurrentGui(completeWeatherData.getCurrent());
        changeDayGui(completeWeatherData.getForecastDayList().get(0),0);
    }

    // Change Current
    public void changeCurrentGui(Current current){
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Change Days TODO text naar een object(bv label),zo komt er een mooie loop
    public void changeDayGui(ForecastDay forecastDay,int numberOfDay){


    }


}