package com.example.javafx_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class HelloApplication extends Application {
    public Button Button2;
    public Button Button1;
    public Label welcomeText;


    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }


    public static void main(String[] args) {

        launch();

    }


    public void onButtonClick(ActionEvent actionEvent) {

        {

            welcomeText.setText("Enter your ZIP Code: ");

        }

    }

    public void onButtonClick2(ActionEvent actionEvent2)


        {

            welcomeText.setText("Hello");

        }

    }
