import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class CurrentWeatherAPI {
    public static String location = "";
    public static String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
    public static String lat = "";
    public static String lon = "";
    public static String cityName = "";
    public static String stateCode = " ";
    public static String zipCode = "";
    public static String countryCode = "";

    @FXML
    public AnchorPane importedFXML;
    public static String responseBody;

    public String getResponseBody() {
        return responseBody;
    }


    public static String currentWeather() throws JSONException {

        responseBody = GeocodeAPI.geocodeLocNoState("New_York", "US");

        responseBody = responseBody.substring(1, responseBody.length() - 1);


        JSONObject obj = new JSONObject(responseBody);

        lat = obj.get("lat").toString();

        lon = obj.get("lon").toString();


        HttpClient httpClient = HttpClient.newHttpClient();

        URI uri = URI.create(
                "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey);

        HttpRequest geocodeLocRequest = HttpRequest.newBuilder().uri(uri).build();
        try {
            HttpResponse<String> response = httpClient.send(geocodeLocRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            responseBody = response.body();
            if (statusCode == 200) {

            }


        } catch (IOException | InterruptedException ignored) {
        }





            return responseBody;



    }
}

