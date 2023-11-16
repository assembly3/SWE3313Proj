import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class CovidNineteen extends HCP {
    public static HttpClient httpClient = HttpClient.newHttpClient();
    public static int counter = 0;

    public static int counter() {

        counter = counter + 1;

        return counter;
    }



    public static Thread[] myArray = new Thread[7];

    public static int integer = 0;

    static String responseBody = "";



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

             //covid19Response(counter());

            }

        }


    public static Thread[] myArrayThread;


    public static void main(String[] args) throws InterruptedException {


        myArrayThread = covid19ResponseThread();

        for (Thread threadObject : myArrayThread) {


             threadObject.start();



        }


    }

}



