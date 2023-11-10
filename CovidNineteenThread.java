package com.example.javafx_project;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CovidNineteenThread {
    public static HttpClient httpClient = HttpClient.newHttpClient();
    public static Double[] myArray = new Double[14];

    public static String covid19Response(int num) {

        URI covid19URI = URI.create("https://disease.sh/v3/covid-19/vaccine/coverage?lastdays=" + num + "&fullData=true");

        HttpRequest covid19Request = HttpRequest.newBuilder().uri(covid19URI).build();

        try {
            HttpResponse<String> response = httpClient.send(covid19Request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {

                String responseBodyString = responseBody.substring(1, responseBody.length() - 1);

                JSONObject obj = new JSONObject(responseBodyString);
                return String.valueOf(obj.getDouble("total"));

            } else {
                return "Error: " + statusCode + "\nResponse Body:\n" + responseBody;
            }
        } catch (IOException | InterruptedException e) {
            return e.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


    synchronized Double totalVaccines() {

        Double sum = (double) 0;

        for (int i = 0; i < myArray.length; i++) {

            myArray[i] = Double.valueOf(covid19Response(i));

            sum += myArray[i];

            System.out.println(sum + " vaccines identified within the past " + i + " days.");
        }

        return sum;

    }


    static class MyThreadCovid implements Runnable {
        Thread thrd;

        static int counter = 0;
        public static CovidNineteenThread covidNineteenThread = new CovidNineteenThread();
        Thread[] threadArray = new Thread[14];

        MyThreadCovid(String name, int integer) {
            thrd = new Thread(this, name);
            threadArray[integer] = thrd;

        }

        @Override
        public void run() {

            Double sum;

            sum = covidNineteenThread.totalVaccines();

            System.out.println(sum + " covid-19 vaccines detected within the past 14 " + "days.");

        }

        public static MyThreadCovid createAndStart(String name, int integer) {

            MyThreadCovid thread = new MyThreadCovid(name, integer);

            thread.thrd.start();
            return thread;

        }
    }


        static class Sync {
            public static void main(String[] args) {


                int counter;

                for(counter = 0; counter <= 1d; counter++) {
                    MyThreadCovid mtc1 = MyThreadCovid.createAndStart("Child number" + counter, counter);


                    try {
                        mtc1.thrd.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                    }
                }
            }




