import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HCP extends Application {


    public static String str = "";

    public static HttpClient httpClient = HttpClient.newHttpClient();

    public static void setStr(String string) {
        str = str + " " + string;
    }

    public static String getStr() {
        return str;
    }
    public static String covid19Response(int integer) {

        double vaccineTotal = 0;
        try {
            URI covid19URI = URI.create("https://disease.sh/v3/covid-19/vaccine/coverage?lastdays=" + integer + "&fullData=true");
            HttpRequest covid19Request = HttpRequest.newBuilder().uri(covid19URI).build();
            HttpResponse<String> response = httpClient.send(covid19Request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {


                String responseBodyString = responseBody.substring(1, responseBody.length() - 1);

                JSONObject obj = new JSONObject(responseBodyString);
                vaccineTotal = obj.getDouble("total");
                setStr(String.valueOf(vaccineTotal));



            }
        } catch (IOException | InterruptedException e) {
            e.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(vaccineTotal);
    }


    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HCP.class.getResource
                ("HealthCarePaneController.fxml"));
        fxmlLoader.setClassLoader(getClass().getClassLoader());

        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.setTitle("Covid - 19 Vaccination Data");
        stage.setScene(scene);
        stage.show();

    }




    public static void main(String[] args) throws InterruptedException {
        launch();
    }

     }



