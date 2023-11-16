package com.example.javafx_project;

import com.google.gson.Gson;
public class jsonParser {
    private final Gson gson;

    public jsonParser() {
        gson = new Gson();
    }

    public String toJson(Object serialize) {
        return gson.toJson(serialize);
    }

    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public <T> void getWeatherData(InputAcceptor input) {
        // Based on the data in the 'input' object, construct API request
        if (input.getLat() != 0.0 && input.getLon() != 0.0) {
        }
        //  CurrentWeatherAPI curWeather = new CurrentWeatherAPI(input.getLat(), input.getLon());
        //  fromJson(curWeather.getCurWeatherJSON(), WeatherData.class);
         /*}else if(input.getCityName() != null && input.getStateCode() != null && input.getCountryCode() != null){
            GeocodeAPI geo = new GeocodeAPI(input.getCityName(), input.getStateCode(), input.getCountryCode());
            GeocodeData data = fromJson(geo.getGeoCodeJSON(), GeocodeData.class);
            getWeatherData(new InputAcceptor(data.getLat(), data.getLon()));
        }else if(input.getCityName() != null && input.getCountryCode() != null){
            GeocodeAPI geo = new GeocodeAPI(input.getCityName(), input.getCountryCode());
            GeocodeData data = fromJson(geo.getGeoCodeJSON(), GeocodeData.class);
            getWeatherData(new InputAcceptor(data.getLat(), data.getLon()));
        }else if(input.getZipCode() != 0 && input.getCountryCode() != null){
            GeocodeAPI geo = new GeocodeAPI(input.getZipCode(), input.getCountryCode());
            GeocodeData data = fromJson(geo.getGeoCodeJSON(), GeocodeData.class);
            getWeatherData(new InputAcceptor(data.getLat(), data.getLon()));
    } */

    }
}