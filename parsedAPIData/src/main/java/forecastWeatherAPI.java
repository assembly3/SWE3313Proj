import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class forecastWeatherAPI {
    private double lat;
    private double lon;
    private String foreWeather;
    public forecastWeatherAPI(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
        foreWeather = forecastWeather(lat, lon);
    }
    public static String forecastWeather(double lat, double lon){
        String apiKey = APIconn.getApiKey();
        HttpClient httpClient = HttpClient.newHttpClient();
        URI uri = URI.create(
                "https://api.openweathermap.org/data/2.5/weather?lat="+ lat + "&lon=" + lon +"&appid=" + apiKey);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
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
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }

    public String getForeWeatherJSON() {
        return foreWeather;
    }
}