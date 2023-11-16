package GUIs;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;

import static GUIs.HealthCareAPI.*;


public class PollenAPI {

    public static String getCoordinate() throws JSONException {

        String responseBody = geocodeLocNoState(HealthCareJFrame.getCityName(),HealthCareJFrame.getCountryCode());

        responseBody = responseBody.substring(1, responseBody.length() - 1);

        JSONObject jsonObj = new JSONObject(responseBody);

        String lat = String.valueOf(jsonObj.getInt("lat"));

        String lon = String.valueOf(jsonObj.getInt("lon"));

        latitude = Double.parseDouble(lat);

        longitude = Double.parseDouble(lon);

        responseBody = pollenLoc(latitude, longitude);

        JSONObject jsonObjTwo = new JSONObject(responseBody);

        //System.out.println(responseBody);

        String pollenStr = jsonObjTwo.toString();

        pollenStr = pollenStr.replace(',',' ');

        pollenStr = pollenStr.replace('\"',' ');

        pollenStr = pollenStr.replace(':',' ');

        String[] pollenStrArray = pollenStr.split("  ");

        StringBuilder pollenString = new StringBuilder();

        for(String str: pollenStrArray)   {

            pollenString.append(str);

        }
        return pollenString.toString();
    }
}
