package com.samsteenmans.weatherapplication.weatherData;

import com.samsteenmans.weatherapplication.data.CompleteWeatherData;
import com.samsteenmans.weatherapplication.interfaces.Observer;
import com.samsteenmans.weatherapplication.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;




/* Here is all the data(forecast) saved
if something want to read the data they just have to implement the Observer and the DisplayElement.

 */

public class WeatherData implements Subject {
    // Variables
    private List<Observer> observers;
    private CompleteWeatherData completeWeatherData;


    // Constructor
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    // Register
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // Remove
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // Notify
    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(completeWeatherData);
        }
    }
    // Changing measurements
    public void measurementsChanged(){
        notifyObservers();
    }

    // Set the measurements
    public void setMeasurements(CompleteWeatherData completeWeatherData){
        this.completeWeatherData = completeWeatherData;
        measurementsChanged();
    }
}
