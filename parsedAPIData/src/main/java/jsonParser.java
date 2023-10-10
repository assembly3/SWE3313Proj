import com.google.gson.Gson;
public class jsonParser {
    private final Gson gson;
    public jsonParser(){
       gson = new Gson();
    }
    public String toJson(Object serialize){
        return gson.toJson(serialize);
    }
    public <T> T fromJson(String json, Class<T> classOfT){
        return gson.fromJson(json, classOfT);
    }

    public <T> WeatherData getWeatherData(InputAcceptor input){
        //Based on the data in the 'input' object, construct API request
        if(input.getLat() != 0.0 && input.getLon() != 0.0){
            currentWeatherAPI curWeather = new currentWeatherAPI(input.getLat(), input.getLon());
            return fromJson(curWeather.getCurWeatherJSON(), WeatherData.class);
        }else if(input.getCityName() != null && input.getStateCode() != null && input.getCountryCode() != null){
            geocodeAPI geo = new geocodeAPI(input.getCityName(), input.getStateCode(), input.getCountryCode());
            GeocodeData data = fromJson(geo.getGeoCodeJSON(), GeocodeData.class);
            getWeatherData(new InputAcceptor(data.getLat(), data.getLon()));
        }else if(input.getCityName() != null && input.getCountryCode() != null){
            geocodeAPI geo = new geocodeAPI(input.getCityName(), input.getCountryCode());
            GeocodeData data = fromJson(geo.getGeoCodeJSON(), GeocodeData.class);
            getWeatherData(new InputAcceptor(data.getLat(), data.getLon()));
        }else if(input.getZipCode() != 0 && input.getCountryCode() != null){
            geocodeAPI geo = new geocodeAPI(input.getZipCode(), input.getCountryCode());
            GeocodeData data = fromJson(geo.getGeoCodeJSON(), GeocodeData.class);
            getWeatherData(new InputAcceptor(data.getLat(), data.getLon()));
        }
    }
}