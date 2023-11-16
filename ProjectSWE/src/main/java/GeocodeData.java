import java.util.Map;
class LocalNames{
    private Map<String, String> localNames;

    public Map<String, String> getLocalNames(){
        return localNames;
    }

}
public class GeocodeData {
    private String name;
    private LocalNames local_names;
    private double lat;
    private double lon;
    private String country;
    private String state;

    public String getName(){
        return name;
    }
    public LocalNames getLocal_names() {
        return local_names;
    }
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }
}