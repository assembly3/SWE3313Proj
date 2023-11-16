import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import org.json.*;


public class CurrentCondition extends Application {

    public static String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";

    public static String cityNameLocation = "New_York";

    public static Double latitude;

    public static Double longitude;

    public static JSONObject temperatures;

    public static Double temperature;

    public static JSONObject descriptions;

    public static Double description;

    public static JSONObject clouds;

    public static String cloud;

    public Button button;

    public TextField weather;

    public TextField descriptionOfWeather;
    public TextField temp;
    public Text sunriseTime;
    public LineChart lineChart;
    public TextField sunriseTime2;


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



        lines = lines.substring(1);

        JSONObject obj = new JSONObject(lines);


        latitude = obj.getDouble("lat");

        longitude = obj.getDouble("lon");

    }


    public void getTemp() {


        try {
            getCoordinates(cityNameLocation);

            URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                    + "&lon=" + longitude + "&appid=" + apiKey);

            URL url;

            url = uri.toURL();

            Scanner sc = new Scanner(url.openStream());

            String lines = "";
            while (sc.hasNextLine()) {
                lines += sc.nextLine();

                JSONObject objTwo = new JSONObject(lines);




                temperatures = objTwo.getJSONObject("main");

                temperature = temperatures.getDouble("temp");


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void getCloud() throws JSONException, IOException, URISyntaxException {

        getCoordinates(cityNameLocation);

        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                + "&lon=" + longitude + "&appid=" + apiKey);

        URL url;

        url = uri.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();

            JSONObject objTwo = new JSONObject(lines);





            clouds = objTwo.getJSONObject("sys");

            cloud = String.valueOf(clouds.getDouble("sunrise"));

        }
    }

    public void getCloud2() throws JSONException, IOException, URISyntaxException {

        getCoordinates(cityNameLocation);

        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                + "&lon=" + longitude + "&appid=" + apiKey);

        URL url;

        url = uri.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();

            JSONObject objTwo = new JSONObject(lines);





            clouds = objTwo.getJSONObject("sys");

            cloud = String.valueOf(clouds.getDouble("sunset"));

        }
    }

    public void getDescription() throws JSONException, IOException, URISyntaxException {

        getCoordinates(cityNameLocation);

        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                + "&lon=" + longitude + "&appid=" + apiKey);

        URL url;

        url = uri.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();

            JSONObject objTwo = new JSONObject(lines);


            descriptions = objTwo.getJSONObject("wind");

            description = descriptions.getDouble("speed");

        }
    }

    public static void main(String[] args) throws InterruptedException, JSONException, IOException, URISyntaxException {


        CurrentCondition currentCondition = new CurrentCondition();

        currentCondition.getTemp();

        currentCondition.getCloud();
        currentCondition.getDescription();



        launch(args);


    }


    public void onButtonClick(ActionEvent actionEvent) throws JSONException, IOException, URISyntaxException {

        if (actionEvent.getSource().equals(button)) {

            temp.setText(temperature.toString());

            weather.setText(cloud);

            descriptionOfWeather.setText(description.toString());

            getCloud2();

            Double num1 = Double.valueOf(cloud);

            getCloud();

            Double num2 = Double.valueOf(cloud);

            Double var = num2 - num1;

            sunriseTime2.setText(String.valueOf(var));

        }
    }
}
