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

      /*  public String weatherMethod(Integer num){

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
*/

}

