package GUIs;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HealthCareAPI {

    public static Double latitude;
    public static Double longitude;
    public static String responseBody = "";

    public static String getResponseBody() {
        return responseBody;
    }

    public static String pollenLoc(Double lat, Double lon){
        String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
        HttpClient httpClient = HttpClient.newHttpClient();
        URI geocoderLocationUri = URI.create(
                "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey);
        HttpRequest pollenLocRequest = HttpRequest.newBuilder().uri(geocoderLocationUri).build();
        try {
            HttpResponse<String> response = httpClient.send(pollenLocRequest, HttpResponse.BodyHandlers.ofString());
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

    public static String geocodeLoc(String cityName, String stateCode, String countryCode) {
        String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
        HttpClient httpClient = HttpClient.newHttpClient();
        URI geocoderLocationUri = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "," + stateCode + "," + countryCode + "&limit=1&appid=" + apiKey);
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

    public static String geocodeLocNoState(String cityName, String countryCode){
        String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
        HttpClient httpClient = HttpClient.newHttpClient();
        URI geocoderLocationUri = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q="+ cityName + "," + countryCode + "&limit=1&appid=" + apiKey);
        HttpRequest geocodeLocRequest = HttpRequest.newBuilder().uri(geocoderLocationUri).build();
        try{
            HttpResponse<String> response = httpClient.send(geocodeLocRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if(statusCode == 200){
                return responseBody;
            }else{
                return "Error: " + statusCode + "\nResponse Body:\n" + responseBody;
            }
        }catch(IOException | InterruptedException e){
            return e.toString();
        }
    }

    public static String geocodeZip(int zipCode, String countryCode){
        String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
        HttpClient httpClient = HttpClient.newHttpClient();
        URI geocoderZipCodeUri = URI.create(
                "http://api.openweathermap.org/geo/1.0/zip?zip="+ zipCode + "," + countryCode +"&appid=" + apiKey);
        HttpRequest geocodeZipRequest = HttpRequest.newBuilder().uri(geocoderZipCodeUri).build();
        try{
            HttpResponse<String> response = httpClient.send(geocodeZipRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if(statusCode == 200){
                return responseBody;
            }else{
                return "Error: " + statusCode + "\nResponse Body:\n" + responseBody;
            }
        }catch(IOException | InterruptedException e){
            return e.toString();
        }
    }

    public static String getCoordinate() throws JSONException {

        responseBody = geocodeLocNoState(HealthCareJFrame.getCityName(),HealthCareJFrame.getCountryCode());

        responseBody = responseBody.substring(1, responseBody.length() - 1);

        JSONObject jsonObj = new JSONObject(responseBody);

        String lat = String.valueOf(jsonObj.getInt("lat"));

        String lon = String.valueOf(jsonObj.getInt("lon"));

        latitude = Double.parseDouble(lat);

        longitude = Double.parseDouble(lon);

        responseBody = pollenLoc(latitude, longitude);

        JSONObject jsonObjTwo = new JSONObject(responseBody);

        //System.out.println(responseBody);

        String pollenStr = jsonObjTwo.toString();

        pollenStr = pollenStr.replace(',',' ');

        pollenStr = pollenStr.replace('\"',' ');

        pollenStr = pollenStr.replace(':',' ');

        String[] pollenStrArray = pollenStr.split("  ");

        StringBuilder pollenString = new StringBuilder();

        for(String str: pollenStrArray)   {

           pollenString.append(str);

       }
        return pollenString.toString();
    }

    public static String getCoordinateTwo() throws JSONException {

        responseBody = geocodeLocNoState(HealthCareJFrame.getCityName(), HealthCareJFrame.getCountryCode());

        responseBody = responseBody.substring(1, responseBody.length() - 1);

        JSONObject jsonObj = new JSONObject(responseBody);

        latitude = jsonObj.getDouble("lat");

        longitude = jsonObj.getDouble("lon");

        //System.out.println(responseBody);

        return latitude + String.valueOf(longitude);

    }

    public static String getCoordinateThree() throws JSONException {

        responseBody = geocodeZip(HealthCareJFrame.getZipCode(),HealthCareJFrame.getCountryCode());

        JSONObject jsonObj = new JSONObject(responseBody);

        String latitude = String.valueOf(jsonObj.getInt("lat"));

        String longitude = String.valueOf(jsonObj.getInt("lon"));

        return latitude + longitude;
    }

}
