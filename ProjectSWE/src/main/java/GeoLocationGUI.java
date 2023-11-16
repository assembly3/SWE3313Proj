import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.TemporalQueries.localTime;


public class GeoLocationGUI extends Application {


    public MenuItem menuItemOne;
    public MenuItem menuItemTwo;
    public MenuItem menuItemThree;
    public MenuItem menuItemFour;
    public MenuItem menuItemFive;
    public MenuItem menuItemSix;
    public MenuItem menuItemSeven;
    public MenuItem menuItemEight;
    public MenuItem menuItemNine;
    public MenuItem menuItemTen;
    public MenuItem menuItemEleven;
    public MenuItem menuItemTwelve;
    public MenuItem menuItemThirteen;
    public MenuItem menuItemFourteen;
    public MenuItem menuItemFifteen;
    public MenuItem menuItemSixteen;
    public MenuItem menuItemSeventeen;
    public MenuItem menuItemEighteen;
    public MenuItem menuItemNineteen;
    public MenuItem menuItemTwenty;
    public MenuItem menuItemTwentyOne;
    public MenuItem menuItemTwentyTwo;
    public MenuItem menuItemTwentyThree;
    public MenuItem menuItemTwentyFour;
    public MenuItem menuItemTwentyFive;
    public MenuItem menuItemTwentySix;
    public MenuItem menuItemTwentySeven;
    public MenuItem menuItemTwentyEight;
    public MenuItem menuItemTwentyNine;
    public MenuItem menuItemThirty;
    public ImageView imageView;
    public Label label;

    public TextField textFieldTwo;
    public TextField textFieldOne;
    public CheckBox checkBox;

    public void setTextFieldOne(String str) {
        textFieldOne.setText(str);
    }
    int latitude;
    int longitude;
    int counter;
    String responseBody;
    static String cityNameVar = "City_Name";
    static String cityNameVarSecond = "City_Name_Second";
    int latitudeTwo;
    int longitudeTwo;

    static String countryCode = "US";


    public void start(Stage primaryStage) throws IOException {

        // FXMLLoader fxmlLoader = new FXMLLoader(CurrentConditionController.class.getResource("CurrentConditionController.fxml"));

        FXMLLoader fxmlloader = new FXMLLoader(GeoLocationGUI.class.getResource("GeoLocationController.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 950, 600);
        primaryStage.setTitle("GeoLocation GUI");
        primaryStage.setScene(scene);

        primaryStage.show();


    }

    public static void main(String[] args) {


        launch(args);
    }

    public static String geocodeLocNoState(String cityName, String countryCode) {
        String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
        HttpClient httpClient = HttpClient.newHttpClient();
        URI geocoderLocationUri = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "," + countryCode + "&limit=1&appid=" + apiKey);
        HttpRequest geocodeLocRequest = HttpRequest.newBuilder().uri(geocoderLocationUri).build();
        try {
            HttpResponse<String> response = httpClient.send(geocodeLocRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {
                return responseBody;
            } else {
                return "Error: " + statusCode + "\nResponse Body:\n" + responseBody;
            }
        } catch (IOException | InterruptedException e) {
            return e.toString();
        }
    }


    public void setTextFieldTwo() throws JSONException {

        responseBody = geocodeLocNoState(cityNameVar, countryCode);

        responseBody = responseBody.substring(1);

        JSONObject jsonObj = new JSONObject(responseBody);

        latitude = jsonObj.getInt("lat");

        longitude = jsonObj.getInt("lon");

        responseBody = geocodeLocNoState(cityNameVarSecond, "US");

        responseBody = responseBody.substring(1);

        JSONObject jsonObjTwo = new JSONObject(responseBody);

        latitudeTwo = jsonObjTwo.getInt("lat");

        longitudeTwo = jsonObjTwo.getInt("lon");

        int latitudeDiff = latitudeTwo - latitude;

        int longitudeDiff = longitudeTwo - longitude;

        textFieldTwo.setText(latitudeDiff + " units of latitude " + longitudeDiff + " units of longitude. ");




    }

    public void actionPerformedCheckBox(ActionEvent actionEvent) {

        Date date = new Date();

        setTextFieldOne(String.valueOf(date.getTime()));

        label.setText(String.valueOf(date.getTime()));

    }

    public void actionPerformedOne(ActionEvent actionEvent) throws JSONException {


        cityNameVar = "New_York";

        if (counter == 16) {

            if (actionEvent.getSource().equals(menuItemOne)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 1;

        if (actionEvent.getSource().equals(menuItemOne)) {

            if ((!cityNameVarSecond.equals("New_York")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

               setTextFieldTwo();
            }

        }

    }
    public void actionPerformedTwo(ActionEvent actionEvent) {



        if (counter == 17) {

            if (actionEvent.getSource().equals(menuItemTwo)) {
                textFieldTwo.setText("Same");

            }

        }

        counter = 2;
        cityNameVar = "Santa_Fe";
    }


    public void actionPerformedThree(ActionEvent actionEvent) {

        if (counter == 18) {

            if (actionEvent.getSource().equals(menuItemTwo)) {
                textFieldTwo.setText("Same");

            }

        }

            counter = 3;
            cityNameVar = "Chicago";
        }



    public void actionPerformedFour(ActionEvent actionEvent) {

        if (counter == 19) {

            if (actionEvent.getSource().equals(menuItemNineteen)) {
                textFieldTwo.setText("Same");
            }

        }


            counter = 4;
            cityNameVar= "Savannah";

        }



    public void actionPerformedFive(ActionEvent actionEvent) {

        if (counter == 20) {

            if (actionEvent.getSource().equals(menuItemTwenty)) {
                textFieldTwo.setText("Same");
            }

        }


        counter = 5;
        cityNameVar= "New_Orleans";

    }

    public void actionPerformedSix(ActionEvent actionEvent) {

        if (counter == 21) {

            if (actionEvent.getSource().equals(menuItemTwentyOne)) {
                textFieldTwo.setText("Same");
            }

        }


        counter = 6;
        cityNameVar= "Charleston";

    }

    public void actionPerformedSeven(ActionEvent actionEvent) {

        if (counter == 22) {

            if (actionEvent.getSource().equals(menuItemTwentyTwo)) {
                textFieldTwo.setText("Same");
            }

        }


        counter = 7;
        cityNameVar= "Portland";

    }

    public void actionPerformedEight(ActionEvent actionEvent) {

        if (counter == 23) {

            if (actionEvent.getSource().equals(menuItemTwentyThree)) {
                textFieldTwo.setText("Same");
            }

        }


        counter = 8;
        cityNameVar= "London";
        countryCode = "GB";

    }

    public void actionPerformedNine(ActionEvent actionEvent) {

        if (counter == 24) {

            if (actionEvent.getSource().equals(menuItemTwentyFour)) {
                textFieldTwo.setText("Same");
            }

        }


        counter = 9;
        cityNameVar= "Shanghai";
        countryCode = "CN";
    }

    public void actionPerformedTen(ActionEvent actionEvent) {

        if (counter == 25) {

            if (actionEvent.getSource().equals(menuItemTwentyFive)) {
                textFieldTwo.setText("Same");
            }
        }

            counter = 10;
            cityNameVar = "Mumbai";
            countryCode = "IN";

    }

    public void actionPerformedEleven(ActionEvent actionEvent) {




    }

    public void actionPerformedTwelve(ActionEvent actionEvent) {
    }

    public void actionPerformedThirteen(ActionEvent actionEvent) {
    }

    public void actionPerformedFourteen(ActionEvent actionEvent) {
    }

    public void actionPerformedFifteen(ActionEvent actionEvent) {
    }

    public void actionPerformedSixteen(ActionEvent actionEvent) throws JSONException {



        if (counter == 1) {
            if (actionEvent.getSource().equals(menuItemSixteen)) {
                textFieldTwo.setText("Same");

            }
        }

        counter = 16;
        cityNameVarSecond = "New_York";

        if (actionEvent.getSource().equals(menuItemSixteen)) {

            if ((!cityNameVar.equals("New_York")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }
        }
    }


    public void actionPerformedSeventeen(ActionEvent actionEvent) throws JSONException {


        if (counter == 2) {
            if (actionEvent.getSource().equals(menuItemSeventeen)) {
                textFieldTwo.setText("Same");
            }

        }

        counter = 17;
        cityNameVarSecond = "Santa_Fe";

        if (actionEvent.getSource().equals(menuItemSeventeen)) {
            if ((!cityNameVar.equals("New_York")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }
        }
    }


    public void actionPerformedEighteen(ActionEvent actionEvent) {

        if (counter == 3) {

            if (actionEvent.getSource().equals(menuItemEighteen)) {
                textFieldTwo.setText("Same");
            }

        }
        if (actionEvent.getSource().equals(menuItemEighteen)) {

            counter = 18;
            cityNameVarSecond = "Chicago";

        }


    }

    public void actionPerformedNineteen(ActionEvent actionEvent) {

        if (counter == 4) {

            if (actionEvent.getSource().equals(menuItemNineteen)) {
                textFieldTwo.setText("Same");
            }

        }
        if (actionEvent.getSource().equals(menuItemNineteen)) {

            counter = 19;
            cityNameVarSecond = "Savannah";

        }
    }

    public void actionPerformedTwenty(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyOne(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyTwo(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyThree(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyFour(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyFive(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentySix(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentySeven(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyEight(ActionEvent actionEvent) {
    }

    public void actionPerformedTwentyNine(ActionEvent actionEvent) {
    }

    public void actionPerformedThirty(ActionEvent actionEvent) {
    }
}