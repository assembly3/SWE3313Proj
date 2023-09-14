package com.example.javafx_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HCPController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Conditions during travel destination.");
    }
}