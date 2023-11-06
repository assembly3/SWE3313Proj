package com.example.javafx_project;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import org.json.*;


public class CurrentCondition extends Application {

    public static String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";

    public static String cityNameLocation = "New_York";


    public static Double latitude;

    public static Double longitude;

    public static JSONObject temperatures;

    public static Double temperature;

    public Button button;
    public TextField windVar;


    @Override
    public void start(Stage primaryStage) throws IOException {


        FXMLLoader fxmlloader = new FXMLLoader(CurrentCondition.class.getResource("CurrentCondition.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void getCoordinates(String cityNameLocation) throws IOException, JSONException {
        URI uriInitial = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q=" + cityNameLocation + "&limit=5&appid=" + apiKey);

        URL url;

        url = uriInitial.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();
        }

        // System.out.println(lines);

        lines = lines.substring(1);

        JSONObject obj = new JSONObject(lines);


        latitude = obj.getDouble("lat");

        longitude = obj.getDouble("lon");

    }


    public void getTemp() {


        try {
                getCoordinates(cityNameLocation);

                URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat="+ latitude
                        + "&lon=" + longitude +"&appid=" + apiKey);

                URL url;

                url = uri.toURL();

                Scanner sc = new Scanner(url.openStream());

                String lines = "";
                while (sc.hasNextLine()) {
                    lines += sc.nextLine();

                JSONObject objTwo = new JSONObject(lines);

                // System.out.println(lines);


                temperatures = objTwo.getJSONObject("main");

                temperature = temperatures.getDouble("temp");




            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void main(String[] args) throws InterruptedException {


        CurrentCondition currentCondition = new CurrentCondition();

        currentCondition.getTemp();

        launch(args);


    }


    public void onButtonClick(ActionEvent actionEvent) {

        if(actionEvent.getSource().equals(button)) {

            windVar.setText(temperature.toString());
        }
    }
}

