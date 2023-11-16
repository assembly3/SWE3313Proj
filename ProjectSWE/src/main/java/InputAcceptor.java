public class InputAcceptor {
    private double lat;
    private double lon;
    private String cityName;
    private String stateCode;
    private int zipCode;
    private String countryCode;
    public InputAcceptor(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
        cityName = null;
        stateCode = null;
        zipCode = 0;
        countryCode = null;
    }
    public InputAcceptor(String cityName, String stateCode, String countryCode){
        this.cityName = cityName;
        this.stateCode = stateCode;
        this.countryCode = stateCode;
        lat = 0.0;
        lon = 0.0;
        zipCode = 0;
    }
    public InputAcceptor(String cityName, String countryCode){
        this.cityName = cityName;
        this.countryCode = countryCode;
        lat = 0.0;
        lon = 0.0;
        zipCode = 0;
        stateCode = null;
    }
    public InputAcceptor(int zipCode, String countryCode){
        this.zipCode = zipCode;
        this.countryCode = countryCode;
        lat = 0.0;
        lon = 0.0;
        cityName = null;
        stateCode = null;
    }
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getCityName() {
        return cityName;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public String getStateCode() {
        return stateCode;
    }
}