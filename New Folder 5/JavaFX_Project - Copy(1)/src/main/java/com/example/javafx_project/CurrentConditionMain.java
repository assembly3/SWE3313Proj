package com.example.javafx_project;


import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.stage.Stage;
import org.json.JSONObject;


import java.awt.*;
import java.io.IOException;
import java.net.URI;

import java.net.URL;
import java.util.Scanner;

public class CurrentConditionMain extends Application {

    public Label id1;

    public Button id2;


        @Override
        public void start (Stage primaryStage) throws IOException {

        // FXMLLoader fxmlLoader = new FXMLLoader(CurrentConditionController.class.getResource("CCController.fxml"));

        FXMLLoader fxmlloader = new FXMLLoader(CurrentConditionMain.class.getResource("CCController.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 400, 300);
        primaryStage.setTitle("Healthcare GUI");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public void onCloseClick (ActionEvent actionEvent){

            System.exit(0);

    }
        public void onHelloButtonClick (ActionEvent actionEvent){

        id1.setText(WeatherCondition.timezone + " " + WeatherCondition.condition + " " + WeatherCondition.temp);

    }

        public static void main (String[]args) {

        WeatherCondition weatherConditionCurr = new WeatherCondition();

        Thread t1 = new Thread(weatherConditionCurr);

        t1.start();

        launch();
    }

    }
