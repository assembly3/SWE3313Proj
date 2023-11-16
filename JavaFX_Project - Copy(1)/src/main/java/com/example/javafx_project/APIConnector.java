package com.example.javafx_project;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class APIConnector{

    private static String apiKey;

    private static final String str ="New York";

    {
        Properties prop = new Properties();

        CurrentWeatherAPI currentWeatherAPI = new CurrentWeatherAPI();
        InputStream input = currentWeatherAPI.getClass().getResourceAsStream("config.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        apiKey = prop.getProperty("api.key");
    }
    public static String getApiKey(){
        return apiKey;
    }

    public static void main(String[] args) throws IOException {
        
        System.out.println(getApiKey());

    }

}