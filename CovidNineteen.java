package com.example.javafx_project;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CovidNineteen{
    public static HttpClient httpClient = HttpClient.newHttpClient();
    public static int counter = 0;

    public static int counter() {

        counter = counter + 1;

        return counter;
    }

    public static String covid19Response(int integer) {

        try {
            URI covid19URI = URI.create("https://disease.sh/v3/covid-19/vaccine/coverage?lastdays=" + integer + "&fullData=true");
            HttpRequest covid19Request = HttpRequest.newBuilder().uri(covid19URI).build();
            HttpResponse<String> response = httpClient.send(covid19Request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {


                String responseBodyString = responseBody.substring(1, responseBody.length() - 1);

                JSONObject obj = new JSONObject(responseBodyString);
                double vaccineTotal = obj.getDouble("total");
                return Double.toString(vaccineTotal);

            } else {
                return "Error: " + statusCode + "\nResponse Body:\n" + responseBody;
            }
        } catch (IOException | InterruptedException e) {
            return e.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Thread[] myArray = new Thread[7];

    public static int integer = 0;

    public static Thread[] covid19ResponseThread() throws InterruptedException {

        do {

            myThread thread = new myThread("CovidThread" + integer);
            myArray[integer] = thread;

            integer = integer + 1;


        } while (integer < 7);


        return myArray;
    }

    static class myThread extends Thread {

        public myThread(String s) {

        }

        @Override
        public void run() {

            System.out.println(covid19Response(counter()));

            }
        }

    public static Thread[] myArrayThread;


    public static void main(String[] args) throws InterruptedException {


        myArrayThread = covid19ResponseThread();

        for (Thread threadObject : myArrayThread) {


             threadObject.start();
             Thread.sleep(5000);

        }

    }

}



