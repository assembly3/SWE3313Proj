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
import java.util.Objects;

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

    static String countryCode2 = "US";


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

        responseBody = geocodeLocNoState(cityNameVarSecond, countryCode2);

        responseBody = responseBody.substring(1);

        JSONObject jsonObjTwo = new JSONObject(responseBody);

        latitudeTwo = jsonObjTwo.getInt("lat");

        longitudeTwo = jsonObjTwo.getInt("lon");

        int latitudeDiff = latitudeTwo - latitude;

        int longitudeDiff = longitudeTwo - longitude;

        textFieldTwo.setText(latitudeDiff + " units of lat " + longitudeDiff + " units of lon.");




    }

    public void actionPerformedCheckBox(ActionEvent actionEvent) {

        Date date = new Date();

        setTextFieldOne(String.valueOf(date.getTime()));

        label.setText(String.valueOf(date.getTime()));

    }

    public void actionPerformedOne(ActionEvent actionEvent) throws JSONException {


            if (counter == 16) {

                if (actionEvent.getSource().equals(menuItemOne)) {
                    textFieldTwo.setText("Same");
                }
            }

            counter = 1;
            cityNameVar = "New_York";
        countryCode = "US";

            if (actionEvent.getSource().equals(menuItemOne)) {

                if ((!cityNameVarSecond.equals("New_York")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                    setTextFieldTwo();
                }

            }

        }

    public void actionPerformedTwo(ActionEvent actionEvent) throws JSONException {



        if (counter == 17) {

            if (actionEvent.getSource().equals(menuItemTwo)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 2;
        cityNameVar = "Santa_Fe";
        countryCode = "US";
        if (actionEvent.getSource().equals(menuItemTwo)) {

            if ((!cityNameVarSecond.equals("Santa_Fe")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }


    public void actionPerformedThree(ActionEvent actionEvent) throws JSONException {


        if (counter == 18) {

            if (actionEvent.getSource().equals(menuItemThree)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 3;
        cityNameVar = "Chicago";
        countryCode = "US";
        if (actionEvent.getSource().equals(menuItemThree)) {

            if ((!cityNameVarSecond.equals("Chicago")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }



    public void actionPerformedFour(ActionEvent actionEvent) throws JSONException {

        if (counter == 19) {

            if (actionEvent.getSource().equals(menuItemFour)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 4;
        cityNameVar = "Savannah";
        countryCode = "US";
        if (actionEvent.getSource().equals(menuItemFour)) {

            if ((!cityNameVarSecond.equals("Savannah")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }



    public void actionPerformedFive(ActionEvent actionEvent) throws JSONException {

        if (counter == 20) {

            if (actionEvent.getSource().equals(menuItemFive)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 5;
        cityNameVar = "New_Orleans";
        countryCode = "US";
        if (actionEvent.getSource().equals(menuItemFive)) {

            if ((!cityNameVarSecond.equals("New_Orleans")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }


    public void actionPerformedSix(ActionEvent actionEvent) throws JSONException {

        if (counter == 21) {

            if (actionEvent.getSource().equals(menuItemSix)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 6;
        cityNameVar = "Charleston";
        countryCode = "US";
        if (actionEvent.getSource().equals(menuItemSix)) {

            if ((!cityNameVarSecond.equals("Charleston")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }

    public void actionPerformedSeven(ActionEvent actionEvent) throws JSONException {

        if (counter == 22) {

            if (actionEvent.getSource().equals(menuItemSeven)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 7;
        cityNameVar = "Portland";
        countryCode = "US";
        if (actionEvent.getSource().equals(menuItemSeven)) {

            if ((!cityNameVarSecond.equals("Portland")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }
    }

    public void actionPerformedEight(ActionEvent actionEvent) throws JSONException {

        if (counter == 23) {

            if (actionEvent.getSource().equals(menuItemEight)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 8;
        cityNameVar= "London";
        countryCode = "GB";

        if (actionEvent.getSource().equals(menuItemEight)) {

            if ((!cityNameVarSecond.equals("London")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }


    }

    public void actionPerformedNine(ActionEvent actionEvent) throws JSONException {

        if (counter == 24) {

            if (actionEvent.getSource().equals(menuItemNine)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 9;
        cityNameVar= "Shanghai";
        countryCode = "CN";

        if (actionEvent.getSource().equals(menuItemNine)) {

            if ((!cityNameVarSecond.equals("Shanghai")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }

    public void actionPerformedTen(ActionEvent actionEvent) throws JSONException {

        if (counter == 25) {

            if (actionEvent.getSource().equals(menuItemTen)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 10;
        cityNameVar = "Mumbai";
        countryCode = "IN";

        if (actionEvent.getSource().equals(menuItemTen)) {

            if ((!cityNameVarSecond.equals("Mumbai")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }

    public void actionPerformedEleven(ActionEvent actionEvent) throws JSONException {

        if (counter == 26) {

            if (actionEvent.getSource().equals(menuItemEleven)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 11;
        cityNameVar = "Luxembourg";
        countryCode = "LU";

        if (actionEvent.getSource().equals(menuItemEleven)) {

            if ((!cityNameVarSecond.equals("Luxembourg")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }




    public void actionPerformedTwelve(ActionEvent actionEvent) throws JSONException {
        if (counter == 27) {

            if (actionEvent.getSource().equals(menuItemTwelve)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 12;
        cityNameVar = "Tokyo";
        countryCode = "JP";

        if (actionEvent.getSource().equals(menuItemTwelve)) {

            if ((!cityNameVarSecond.equals("Tokyo")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }

    public void actionPerformedThirteen(ActionEvent actionEvent) throws JSONException {
        if (counter == 28) {

            if (actionEvent.getSource().equals(menuItemThirteen)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 13;
        cityNameVar = "Mexico_City";
        countryCode = "MX";

        if (actionEvent.getSource().equals(menuItemTwelve)) {

            if ((!cityNameVarSecond.equals("Mexico_City")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }


    public void actionPerformedFourteen(ActionEvent actionEvent) throws JSONException {
        if (counter == 29) {

            if (actionEvent.getSource().equals(menuItemFourteen)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 14;
        cityNameVar = "Cairo";
        countryCode = "EG";

        if (actionEvent.getSource().equals(menuItemTwelve)) {

            if ((!cityNameVarSecond.equals("Cairo")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }

    public void actionPerformedFifteen(ActionEvent actionEvent) throws JSONException {
        if (counter == 30) {

            if (actionEvent.getSource().equals(menuItemFifteen)) {
                textFieldTwo.setText("Same");
            }
        }

        counter = 15;
        cityNameVar = "Zurich";
        countryCode = "CH";

        if (actionEvent.getSource().equals(menuItemTwelve)) {

            if ((!cityNameVarSecond.equals("Zurich")) && (!cityNameVarSecond.equals("City_Name_Second"))) {

                setTextFieldTwo();
            }

        }

    }

    public void actionPerformedSixteen(ActionEvent actionEvent) throws JSONException {


        if (counter == 1) {
            if (actionEvent.getSource().equals(menuItemSixteen)) {
                textFieldTwo.setText("Same");

            }
        }

        counter = 16;
        cityNameVarSecond = "New_York";
        countryCode2 = "US";
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
        countryCode2 = "US";
        if (actionEvent.getSource().equals(menuItemSeventeen)) {
            if ((!cityNameVar.equals("Santa_Fe")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }
        }
    }


    public void actionPerformedEighteen(ActionEvent actionEvent) throws JSONException {

        if (counter == 3) {
            if (actionEvent.getSource().equals(menuItemEighteen)) {
                textFieldTwo.setText("Same");
            }

        }

        counter = 18;
        cityNameVarSecond = "Chicago";
        countryCode2 = "US";
        if (actionEvent.getSource().equals(menuItemEighteen)) {
            if ((!cityNameVar.equals("Chicago")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }
        }


    }

    public void actionPerformedNineteen(ActionEvent actionEvent) throws JSONException {

        if (counter == 4) {

            if (actionEvent.getSource().equals(menuItemNineteen)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 19;
        cityNameVarSecond = "Savannah";
        countryCode2 = "US";
        if (actionEvent.getSource().equals(menuItemNineteen)) {

            if ((!cityNameVar.equals("Savannah")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void actionPerformedTwenty(ActionEvent actionEvent) throws JSONException {

        if (counter == 5) {

            if (actionEvent.getSource().equals(menuItemTwenty)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 20;
        cityNameVarSecond = "New_Orleans";
        countryCode2 = "US";
        if (actionEvent.getSource().equals(menuItemTwenty)) {

            if ((!cityNameVar.equals("New_Orleans")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }


    public void actionPerformedTwentyOne(ActionEvent actionEvent) throws JSONException {

        if (counter == 6) {

            if (actionEvent.getSource().equals(menuItemTwentyOne)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 21;
        cityNameVarSecond = "Charleston";
        countryCode2 = "US";
        if (actionEvent.getSource().equals(menuItemTwentyOne)) {

            if ((!cityNameVar.equals("Charleston")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }


    public void actionPerformedTwentyTwo(ActionEvent actionEvent) throws JSONException {
        if (counter == 7) {

            if (actionEvent.getSource().equals(menuItemTwentyTwo)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 22;
        cityNameVarSecond = "Portland";
        countryCode2 = "US";
        if (actionEvent.getSource().equals(menuItemTwentyTwo)) {

            if ((!cityNameVar.equals("Portland")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void actionPerformedTwentyThree(ActionEvent actionEvent) throws JSONException {

        if (counter == 8) {

            if (actionEvent.getSource().equals(menuItemTwentyThree)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 23;
        cityNameVarSecond = "London";
        countryCode2 = "GB";
        if (actionEvent.getSource().equals(menuItemTwentyThree)) {

            if ((!cityNameVar.equals("London")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }

    }

    public void actionPerformedTwentyFour(ActionEvent actionEvent) throws JSONException {
        if (counter == 9) {

            if (actionEvent.getSource().equals(menuItemTwentyFour)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 24;
        cityNameVarSecond = "Shanghai";
        countryCode2 = "CN";
        if (actionEvent.getSource().equals(menuItemTwentyFour)) {

            if ((!cityNameVar.equals("Shanghai")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void actionPerformedTwentyFive(ActionEvent actionEvent) throws JSONException {
        if (counter == 10) {

            if (actionEvent.getSource().equals(menuItemTwentyFive)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 25;
        cityNameVarSecond = "Mumbai";
        countryCode2 = "IN";
        if (actionEvent.getSource().equals(menuItemTwentyFive)) {

            if ((!cityNameVar.equals("Mumbai")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void actionPerformedTwentySix(ActionEvent actionEvent) throws JSONException {
        if (counter == 11) {

            if (actionEvent.getSource().equals(menuItemTwentySix)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 26;
        cityNameVarSecond = "Luxembourg";
        countryCode2 = "LU";
        if (actionEvent.getSource().equals(menuItemTwentySix)) {

            if ((!cityNameVar.equals("Luxembourg")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }
    public void actionPerformedTwentySeven(ActionEvent actionEvent) throws JSONException {

        if (counter == 12) {

            if (actionEvent.getSource().equals(menuItemTwentySeven)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 27;
        cityNameVarSecond = "Tokyo";
        countryCode2 = "JP";
        if (actionEvent.getSource().equals(menuItemTwentySeven)) {

            if ((!cityNameVar.equals("Tokyo")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }


    public void actionPerformedTwentyEight(ActionEvent actionEvent) throws JSONException {
        if (counter == 13) {

            if (actionEvent.getSource().equals(menuItemTwentyEight)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 28;
        cityNameVarSecond = "Mexico_City";
        countryCode2 = "MX";
        if (actionEvent.getSource().equals(menuItemTwentyEight)) {

            if ((!cityNameVar.equals("Mexico_City")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void actionPerformedTwentyNine(ActionEvent actionEvent) throws JSONException {
        if (counter == 14) {

            if (actionEvent.getSource().equals(menuItemTwentyNine)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 29;
        cityNameVarSecond = "Cairo";
        countryCode2 = "EG";
        if (actionEvent.getSource().equals(menuItemTwentyNine)) {

            if ((!cityNameVar.equals("Ciro")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void actionPerformedThirty(ActionEvent actionEvent) throws JSONException {
        if (counter == 15) {

            if (actionEvent.getSource().equals(menuItemThirty)) {
                textFieldTwo.setText("Same");
            }

        }
        counter = 30;
        cityNameVarSecond = "Zurich";
        countryCode2 = "CH";
        if (actionEvent.getSource().equals(menuItemThirty)) {

            if ((!cityNameVar.equals("Zurich")) && (!cityNameVar.equals("City_Name"))) {

                setTextFieldTwo();

            }

        }
    }

    public void onClearButton(ActionEvent actionEvent) {

        if((Objects.equals(cityNameVar, "City_Name")) && (!Objects.equals(cityNameVarSecond, "City_Name_Second")))
        {cityNameVarSecond = "City_Name_Second";}
            if((!Objects.equals(cityNameVar, "City_Name")) && (Objects.equals(cityNameVarSecond, "City_Name_Second")))
            {cityNameVar = "City_Name";}
        textFieldTwo.setText("");


            countryCode = "US";
        countryCode2 = "US";
    }
}