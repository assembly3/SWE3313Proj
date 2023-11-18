import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONObject.*;
import org.json.simple.parser.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CurrentWeatherAPI {
    public String location = "st. louis";
    public static String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
    public static String lat = "38.6270";
    public static String lon = "-90.1994";
    public String cityName = "";
    public String stateCode = " ";
    public String zipCode = "";
    public String countryCode = "";

    public static String responseBody;

    public String getResponseBody() {
        return responseBody;
    }
    public CurrentWeatherAPI()
    {
        //CurrentWeatherAPI classCurrentWeather = new CurrentWeatherAPI();
    };

    public TableModel currentWeather(String cityNameLocation) {


        HttpClient httpClient = HttpClient.newHttpClient();

        //URI uri = URI.create(
        //       "https://api.openweathermap.org/data/2.5/weather?lat="+ lat + "&lon=" + lon +"&appid=" + apiKey);


        URI geocoderLocationUri = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q=" + cityNameLocation + "&limit=5&appid=" + apiKey);

        //URI geocoderZipCodeUri = URI.create(
        //"http://api.openweathermap.org/geo/1.0/zip?zip="+ zipCode + "," + countryCode +"&appid=" + apiKey);


        //HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpRequest geocodeLocRequest = HttpRequest.newBuilder().uri(geocoderLocationUri).build();
        //HttpRequest geocodeZipRequest = HttpRequest.newBuilder().uri(geocoderZipCodeUri).build();

        String lines2 = "";

        String lines3 = "";

        TableModel dataModel = null;

        try {
            HttpResponse<String> response = httpClient.send(geocodeLocRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();


            responseBody = response.body();

            responseBody = responseBody.substring(1, responseBody.length() - 1);

            JSONObject jsonObj = new JSONObject(responseBody);

            lines2 += jsonObj.getInt("lat");

            lines3 += jsonObj.getInt("lon");

            String finalLines2 = lines2;

            String finalLines3 = lines3;

            dataModel = new AbstractTableModel() {
                @Override
                public int getRowCount() {
                    return 15;
                }

                @Override
                public int getColumnCount() {
                    return 2;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {

                    if(columnIndex == 1)

                    {
                        return finalLines2;}

                    if(columnIndex == 2)

                    {
                        return finalLines3;}

                    return null;
                }
            };


            // if(statusCode == 200){
            //    System.out.println(getResponseBody());  //"Response Body:\n"
            // }else{
            //    System.out.println("Error: " + statusCode);
            //    System.out.println(responseBody);  //"Response Body:\n"
            // }

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        return dataModel;
    }
}


