package com.example.javafx_project;

import java.util.List;
class Coord{
    private double lon;
    private double lat;
    public double getLon() {
        return lon;
    }
    public double getLat() {
        return lat;
    }
}
class Weather{
    private String id;
    private String main;
    private String description;
    private String icon;
    public String getId() {
        return id;
    }
    public String getMain() {
        return main;
    }
    public String getDescription() {
        return description;
    }
    public String getIcon() {
        return icon;
    }
}
class MainWeather{
    private String temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String humidity;
    private String sea_level;
    private String grnd_level;

    public String getTemp() {
        return temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getSea_level() {
        return sea_level;
    }

    public String getGrnd_level() {
        return grnd_level;
    }
}
class Wind{
    private String speed;
    private String deg;
    private String gust;

    public String getSpeed() {
        return speed;
    }

    public String getDeg() {
        return deg;
    }

    public String getGust() {
        return gust;
    }
}
class Rain{
    private String _1h;

    public String get_1h() {
        return _1h;
    }
}
class Clouds{
    private String all;

    public String getAll() {
        return all;
    }
}
class Sys{
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
public class WeatherData{
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}