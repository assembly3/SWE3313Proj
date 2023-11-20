package GUIs;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import static GUIs.HealthCareAPI.*;


public class PollenAPI {

    public static String getCoordinate() throws JSONException, ParseException {

        String responseBody = geocodeLocNoState(HealthCareJFrame.getCityName(),HealthCareJFrame.getCountryCode());

        responseBody = responseBody.substring(1, responseBody.length() - 1);

        JSONObject jsonObj = new JSONObject(responseBody);

        String lat = String.valueOf(jsonObj.getInt("lat"));

        String lon = String.valueOf(jsonObj.getInt("lon"));

        latitude = Double.parseDouble(lat);

        longitude = Double.parseDouble(lon);

        responseBody = pollenLoc(latitude, longitude);

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(responseBody);

        org.json.simple.JSONObject object2 = (org.json.simple.JSONObject) obj;

        Object obj3 = object2.get("list");

        String string = obj3.toString();

        String string2 = string.substring(1, string.length() - 1);

        Object obj4 = parser.parse(string2);

        org.json.simple.JSONObject object3 = (org.json.simple.JSONObject) obj4;

        Object obj5 = object3.get("components");

        return obj5.toString();


    }
}
