package com.example.javafx_project;

import org.json.*;

import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class WeatherCondition implements Runnable{

    public static String timezone;

    public static String condition;

    public static double temp;

    @Override
    public void run() {

        try {

            while (true) {


                URI uri = new URI("https://get.geojs.io/v1/ip/geo.json");

                URL url;

                url = uri.toURL();

                Scanner sc = new Scanner(url.openStream());

                String lines = "";
                while (sc.hasNextLine()) {
                    lines += sc.nextLine();
                }

                JSONObject obj = new JSONObject(lines);


                timezone = obj.getString("timezone");



                Thread.sleep(9000000);

            }

              }catch(Exception e){
                System.out.println(e.getMessage());

        }
    }
}
