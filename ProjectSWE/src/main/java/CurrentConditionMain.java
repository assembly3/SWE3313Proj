import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.StringJoiner;

import static java.awt.SystemColor.menu;

public class CurrentConditionMain extends Application {

    public TextField textField;
    public MenuItem menuItem1;
    public TextArea textArea;
    public MenuButton menuButton;
    public MenuButton menuButtonTwo;
    public MenuItem menuItem2;
    public MenuItem menuItem3;
    public MenuItem menuItem4;
    public MenuItem menuItem5;
    public MenuItem menuItem6;
    public MenuItem menuItem7;
    public MenuItem menuItem8;
    public MenuItem menuItem9;
    public MenuItem menuItem10;
    public MenuItem menuItem11;
    public MenuItem menuItem12;
    public MenuItem menuItem13;
    public MenuItem menuItem14;
    public MenuItem menuItem15;
    public MenuItem menuItem21;
    public MenuItem menuItem22;
    public MenuItem menuItem23;
    public MenuItem menuItem24;
    public MenuItem menuItem25;
    public MenuItem menuItem26;
    public MenuItem menuItem27;
    public MenuItem menuItem28;
    public MenuItem menuItem29;
    public MenuItem menuItem30;
    public MenuItem menuItem31;
    public MenuItem menuItem32;
    public MenuItem menuItem33;
    public MenuItem menuItem34;
    public MenuItem menuItem35;
    public static String cityNameVar;


    @Override
        public void start (Stage primaryStage) throws IOException {

        // FXMLLoader fxmlLoader = new FXMLLoader(CurrentConditionController.class.getResource("CurrentConditionController.fxml"));

        FXMLLoader fxmlloader = new FXMLLoader(CurrentConditionMain.class.getResource("CurrentConditionController.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 1500, 800);
        primaryStage.setTitle("Weather Condition GUI");

        JFrame frameOne = new JFrame();
        JTable jTable = new JTable(1,6);


        TextField chartTitle = new TextField("Weekly Forecast");
        chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        chartTitle.setAlignment(Pos.TOP_LEFT);






        //Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);


        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public static void main (String[]args) {

        launch(args);


    }

        public String weatherMethod(MenuItem obj, String str){

            int i = Integer.parseInt(obj.toString().substring(obj.toString().length() - 1));

            if((i >= 1) && i <= 15)

        {

            textField.setText("Displaying Queried API Data Info for" + str + ".");

            CurrentWeatherAPI classCurrentWeatherAPI = new CurrentWeatherAPI();

            String latitude = ((String) classCurrentWeatherAPI.currentWeather
                    (str).getValueAt(i,1));

            String longitude = ((String) classCurrentWeatherAPI.currentWeather
                    (str).getValueAt(i, 2));

            return latitude + longitude;

        }

            if((i >= 21) && (i <= 35))


        {
            textField.setText("Displaying Queried API Data Info for" + str + ".");

            CurrentWeatherAPI classCurrentWeatherAPI = new CurrentWeatherAPI();

            String latitude = ((String) classCurrentWeatherAPI.currentWeather
                    (str).getValueAt(i - 21,1));

            String longitude = ((String) classCurrentWeatherAPI.currentWeather
                    (str).getValueAt(i - 21 , 2));

            return latitude + longitude;


        }

            return null;
        }

    public void onMenuLabel1Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem1)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem1, cityNameVar));

        }

    }

    
    public void onMenuLabel2Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem2)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem2, cityNameVar));

        }
    }

    public void onMenuLabel3Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem3)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem3, cityNameVar));

        }

    }

    public void onMenuLabel4Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem4)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem4, cityNameVar));

        }

    }

    public void onMenuLabel5Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem5)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem5, cityNameVar));

        }


    }

    public void onMenuLabel6Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem6)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem6, cityNameVar));

        }


    }

    public void onMenuLabel7Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem7)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem7, cityNameVar));

        }

    }

    public void onMenuLabel8Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem8)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem8, cityNameVar));

        }

    }

    public void onMenuLabel9Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem9)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem9, cityNameVar));

        }

    }

    public void onMenuLabel10Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem10)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem10, cityNameVar));
        }

    }

    public void onMenuLabel11Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem11)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem11, cityNameVar));
        }

    }

    public void onMenuLabel12Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem12)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem12, cityNameVar));

        }


    }

    public void onMenuLabel13Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem13)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem13, cityNameVar));

        }


    }

    public void onMenuLabel14Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem14)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem14, cityNameVar));

        }


    }

    public void onMenuLabel15Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem15)){

            textField.setText("Displaying Queried API Data Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem15, cityNameVar));

        }

    }

    public void onMenuButtonClick(ActionEvent actionEvent) {

        }

    public void onMenuButtonTwoClick(ActionEvent actionEvent) {

    }

    public void onMenuLabel21Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem21)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem21, cityNameVar));
        }
    }

    public void onMenuLabel22Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem22)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem22, cityNameVar));
        }

    }

    public void onMenuLabel23Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem23)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem23, cityNameVar));
        }

    }

    public void onMenuLabel24Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem24)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem24, cityNameVar));
        }

    }

    public void onMenuLabel25Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem25)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem25, cityNameVar));
        }

    }

    public void onMenuLabel26Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem26)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem26, cityNameVar));
        }

    }

    public void onMenuLabel27Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem27)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem27, cityNameVar));
        }

    }

    public void onMenuLabel28Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem28)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem28, cityNameVar));
        }

    }

    public void onMenuLabel29Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem29)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem29, cityNameVar));
        }

    }

    public void onMenuLabel30Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem30)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem30, cityNameVar));
        }

    }

    public void onMenuLabel31Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem31)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem31, cityNameVar));
        }

    }

    public void onMenuLabel32Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem32)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem32, cityNameVar));
        }

    }

    public void onMenuLabel33Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem33)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem33, cityNameVar));
        }

    }

    public void onMenuLabel34Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem34)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem34, cityNameVar));
        }

    }

    public void onMenuLabel35Click(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(menuItem35)) {

            textField.setText("Displaying Queried API Distance Info for" + cityNameVar);

            textField.setText(weatherMethod(menuItem35, cityNameVar));
        }

    }
}

