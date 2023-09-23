import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class currentWeatherAPI {
    public static void main(String[] args){
        String location = "st. louis";
        String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";
        String lat = "38.6270";
        String lon = "-90.1994";
        String cityName = "";
        String stateCode = " ";
        String zipCode = "";
        String countryCode = "";

        HttpClient httpClient = HttpClient.newHttpClient();

        URI uri = URI.create(
                "https://api.openweathermap.org/data/2.5/weather?lat="+ lat + "&lon=" + lon +"&appid=" + apiKey);
        //URI geocoderLocationUri = URI.create(
        //"http://api.openweathermap.org/geo/1.0/direct?q="+ cityName + stateCode+ "," +countryCode+ "}&limit=3&appid=" + apiKey);
        //URI geocoderZipCodeUri = URI.create(
        //"http://api.openweathermap.org/geo/1.0/zip?zip="+ zipCode + "," + countryCode +"&appid=" + apiKey);

        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        //HttpRequest geocodeLocRequest = HttpRequest.newBuilder().uri(geocoderLocationUri).build();
        //HttpRequest geocodeZipRequest = HttpRequest.newBuilder().uri(geocoderZipCodeUri).build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if(statusCode == 200){
                System.out.println("Response Body:\n" + responseBody);
            }else{
                System.out.println("Error: " + statusCode);
                System.out.println("Response Body:\n" + responseBody);
            }

        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
