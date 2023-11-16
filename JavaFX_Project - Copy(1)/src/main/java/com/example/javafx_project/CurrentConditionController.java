package com.example.javafx_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CurrentConditionController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Condition based on the address of your current IP.");
    }
}