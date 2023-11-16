import java.util.List;
public class foreWeatherData {
    private String cod;
    private String message;
    private int cnt;
    private List<Forecast> list;
    private City city;

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<Forecast> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

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
    public long getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getPop() {
        return pop;
    }

    public Rain getRain() {
        return rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }
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

    public double getTemp() {
        return temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSea_level() {
        return sea_level;
    }

    public int getGrnd_level() {
        return grnd_level;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }
}
class foreWeather {
    private int id;
    private String main;
    private String description;
    private String icon;
    public int getId() {
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
class foreClouds {
    private int all;
    public int getAll() {
        return all;
    }
}
class foreWind{
    private double speed;
    private int deg;
    private double gust;
    public double getSpeed() {
        return speed;
    }
    public int getDeg() {
        return deg;
    }
    public double getGust() {
        return gust;
    }
}
class foreRain{
    private double _3h;
    public double get_3h() {
        return _3h;
    }
}
class Snow{
    private double _3h;
    public double get_3h() {
        return _3h;
    }
}
class foreSys{
    private String pod;
    public String getPod() {
        return pod;
    }
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getTimezone() {
        return timezone;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
class foreCoord{
    private double lat;
    private double lon;
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
}