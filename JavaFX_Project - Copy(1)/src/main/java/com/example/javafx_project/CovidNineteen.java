package com.example.javafx_project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CovidNineteen {

    public static HttpClient httpClient = HttpClient.newHttpClient();
    public static URI covid19URI = URI.create("https://disease.sh/v3/covid-19/all?yesterday=yesterdaydf");
    public static HttpRequest covid19Request = HttpRequest.newBuilder().uri(covid19URI).build();

    public static String covid19Response(String string) {

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

    public static void main(String[] args){
        int index = 0;
        String covid19Str = covid19Response(Integer.toString(index));
        System.out.println(covid19Str);
    }

}


