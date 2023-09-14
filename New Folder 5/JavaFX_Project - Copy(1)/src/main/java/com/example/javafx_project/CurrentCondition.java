package com.example.javafx_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

import org.json.*;

public class CurrentCondition extends Application implements Runnable {


    static String time;

    static String condition;

    static double temp;


    @Override
    public void start(Stage stage) throws IOException {


        GridPane myGrid = new GridPane();

        Scene scene = new Scene(myGrid, 400, 300);

        // FXMLLoader fxmlLoader = new FXMLLoader(CurrentConditionController.class.getResource("CCController.fxml"));


        stage.setScene(scene);
        stage.show();

        Text actiontarget1 = new Text();
        myGrid.add(actiontarget1,0,50);

        Text actiontarget2 = new Text();
        myGrid.add(actiontarget2,0,75);

        Text actiontarget3 = new Text();
        myGrid.add(actiontarget3,0,100);

        Button clearButton = new Button("Clear");
        myGrid.add(clearButton, 50,50);

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget1.setText(time);
            }
        });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                actiontarget2.setText(condition);
            }
        });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                actiontarget3.setText(Double.toString(temp));
            }
        });


        stage.setScene(scene);
        stage.setTitle("Current Conditions");
        stage.show();
    }

    @Override
    public void run() {

        try {
            while(true) {
                URI uri = new URI("https://api.weather.gov/stations/pbservations/latest");

                URL url;

                url = uri.toURL();

                Scanner sc = new Scanner(url.openStream());

                String lines = "";
                while(sc.hasNextLine()){
                    lines += sc.nextLine();
                }

                JSONObject obj = new JSONObject(lines);
                String timeStamp = obj.getJSONObject("properties").getString("timestamp");
                time = timeStamp;
                String conditions = obj.getJSONObject("properties").getString("textDescription");
                condition = conditions;
                double temperature = obj.getJSONObject("properties").getDouble("temperature");


                double tempF = (temperature * 9/5) + 32;

                temp = tempF;



            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }



        public static void main(String[] args){


        launch(args);
    }

}
