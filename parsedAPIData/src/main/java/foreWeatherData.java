import java.util.List;
public class foreWeatherData {
    private String cod;
    private String message;
    private int cnt;
    private List<Forecast> list;
    private City city;

}
class Forecast{
    private long dt;
    private Main main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private double pop;
    private Rain rain;
    private Snow snow;
    private Sys sys;
    private String dt_txt;
}
class foreMain {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int sea_level;
    private int grnd_level;
    private int humidity;
    private double temp_kf;
}
class foreWeather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
class foreClouds {
    private int all;
}
class foreWind{
    private double speed;
    private int deg;
    private double gust;
}
class foreRain{
    private double _3h;
}
class Snow{
    private double _3h;
}
class foreSys{
    private String pod;
}
class City{
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;
    private int timezone;
    private long sunrise;
    private long sunset;
}
class foreCoord{
    private double lat;
    private double lon;
}