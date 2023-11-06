package com.example.javafx_project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.javafx_project.CovidNineteenThread.*;

public class CovidNineteenThread {

    public static HttpClient httpClient = HttpClient.newHttpClient();
    static URI covid19URI = URI.create("https://disease.sh/v3/covid-19/all?yesterday=1");
    public static HttpRequest covid19Request = HttpRequest.newBuilder().uri(covid19URI).build();
    public static String responseBody;
    public static int counter = 0;

    public static String covid19Response(String httpRequestVar) {

        covid19URI = URI.create("https://disease.sh/v3/covid-19/vaccine/coverage/countries?lastdays=" + httpRequestVar);

        try {
            HttpResponse<String> response = httpClient.send(covid19Request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {
                return responseBody;
            } else {
                return "Error: " + statusCode + "\nResponse Body:\n" + responseBody;
            }
        } catch (IOException | InterruptedException e) {
            return e.toString();
        }
    }


    synchronized String stringArray(String[] array) {
        responseBody = "";

        for (int i = 0; i < array.length; i++) {

            responseBody += array[i];

            System.out.println(Thread.currentThread().getName() + "identified within the past" + i + "days.");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return responseBody;
    }

}
    class MyThreadCovid implements Runnable {
        public Thread thrd;
        public static CovidNineteenThread covidResponse = new CovidNineteenThread();

        public static Thread[] covidResponseArray= new Thread[10];
        public static String responseQuery;

        MyThreadCovid(String name, Thread[] covidThreadArray) {

            thrd = new Thread(this, name);

            while (counter < covidThreadArray.length) {
                covidResponseArray[counter] = thrd;
                counter = counter + 1;
            }


        }

        public static MyThreadCovid createAndStart(String name, Thread[] covidResponseArray) {

            int num = 0;

            MyThreadCovid myThrd = null;
            while (num <= counter) {
                myThrd = new MyThreadCovid(name, covidResponseArray);
                num = num + 1;
            }

            assert myThrd != null;
            myThrd.thrd.start();
            return myThrd;
        }

        @Override
        public void run() {
            String query;

            System.out.println(thrd.getName() + " starting.");

            int i;
            for (i = 0; i <= 9; i++) {
                responseQuery = covidResponseArray[i].toString();

                query = responseQuery;

                System.out.println("The query for " + thrd.getName() +
                        " is " + query + covidResponseArray[i].getName());

                System.out.println(thrd.getName() + " terminating.");

                if (i == 9)
                    break;
            }
        }

        static class Sync {
            public static void main(String[] args) {


                int index = 0;
                Thread[] myArray = new Thread[10];
                MyThreadCovid[] covidArray = new MyThreadCovid[10];

                for (index = 1; index <= 9; index++) {

                    CovidNineteenThread.responseBody = CovidNineteenThread.covid19Response(Integer.toString(index));



                    MyThreadCovid.createAndStart("Thread #" + index, myArray);

                    covidArray[index] = MyThreadCovid.createAndStart("Thread #" + index, myArray);

                    try {
                        covidArray[index].thrd.join();

                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }


