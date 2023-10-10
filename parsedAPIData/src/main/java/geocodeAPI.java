import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class geocodeAPI {
    private String cityName;
    private String stateCode;
    private String countryCode;
    private int zipCode;
    private String geoCode;
    public geocodeAPI(String cityName, String stateCode, String countryCode){
        this.cityName = cityName;
        this.stateCode = stateCode;
        this.countryCode = countryCode;
        geoCode = geocodeLoc(cityName, stateCode, countryCode);
    }
    public geocodeAPI(String cityName, String countryCode){
        this.cityName = cityName;
        this.countryCode = countryCode;
        geoCode = geocodeLocNoState(cityName, countryCode);
    }
    public geocodeAPI(int zipCode, String countryCode){
        this.zipCode = zipCode;
        this.countryCode = countryCode;
        geoCode = geocodeZip(zipCode, countryCode);
    }
    public static String geocodeLoc(String cityName, String stateCode, String countryCode){
        String apiKey = APIconn.getApiKey();
        HttpClient httpClient = HttpClient.newHttpClient();
        URI geocoderLocationUri = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q="+ cityName + "," + stateCode + "," + countryCode + "&limit=1&appid=" + apiKey);
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
    public static String geocodeLocNoState(String cityName, String countryCode){
        String apiKey = APIconn.getApiKey();
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
        String apiKey = APIconn.getApiKey();
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
    public String getGeoCodeJSON() {
        return geoCode;
    }
}
