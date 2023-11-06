package com.example.javafx_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HCP extends Application {
    public javafx.scene.control.Label welcomeText;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HealthCarePaneController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.setTitle("Hello people!");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {

        welcomeText.setText("You are in good health.");

    }
}

