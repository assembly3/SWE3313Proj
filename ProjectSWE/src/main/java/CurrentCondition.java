import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import org.json.*;

import javax.swing.*;


public class CurrentCondition extends Application {

    public static String apiKey = "f494fe829950ebc8a41eb4e545a6a4ca";

    public static String cityNameLocation = "New_York";

    public static Double latitude;

    public static Double longitude;

    public static JSONObject temperatures;

    public static Double temperature;

    public static JSONObject descriptions;

    public static Double description;

    public static JSONObject clouds;

    public static String cloud;

    public Button button;

    public TextField weather;

    public TextField descriptionOfWeather;
    public TextField temp;
    public Text sunriseTime;

    public TextField sunriseTime2;
    public ListView listForecast;
    public ListView forecastWeather;
    public TextField textField;
    public AnchorPane importedFXML;

    public Button buttonTwo;
    public TableColumn weatherTable;
    public ListView listView;
    public TextArea textArea;


    @Override
    public void start(Stage primaryStage) throws IOException {


        FXMLLoader fxmlloader = new FXMLLoader(CurrentCondition.class.getResource("CurrentCondition.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 800, 500);
        primaryStage.setScene(scene);

        primaryStage.show();


    }

    public void getCoordinates(String cityNameLocation) throws IOException, JSONException {
        URI uriInitial = URI.create(
                "http://api.openweathermap.org/geo/1.0/direct?q=" + cityNameLocation + "&limit=5&appid=" + apiKey);

        URL url;

        url = uriInitial.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();
        }



        lines = lines.substring(1);

        JSONObject obj = new JSONObject(lines);


        latitude = obj.getDouble("lat");

        longitude = obj.getDouble("lon");

    }


    public void getTemp() {


        try {
            getCoordinates(cityNameLocation);

            URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                    + "&lon=" + longitude + "&appid=" + apiKey);

            URL url;

            url = uri.toURL();

            Scanner sc = new Scanner(url.openStream());

            String lines = "";
            while (sc.hasNextLine()) {
                lines += sc.nextLine();

                JSONObject objTwo = new JSONObject(lines);




                temperatures = objTwo.getJSONObject("main");

                temperature = temperatures.getDouble("temp");


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void getCloud() throws JSONException, IOException, URISyntaxException {

        getCoordinates(cityNameLocation);

        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                + "&lon=" + longitude + "&appid=" + apiKey);

        URL url;

        url = uri.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();

            JSONObject objTwo = new JSONObject(lines);





            clouds = objTwo.getJSONObject("sys");

            cloud = String.valueOf(clouds.getDouble("sunrise"));

        }
    }

    public void getCloud2() throws JSONException, IOException, URISyntaxException {

        getCoordinates(cityNameLocation);

        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                + "&lon=" + longitude + "&appid=" + apiKey);

        URL url;

        url = uri.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();

            JSONObject objTwo = new JSONObject(lines);





            clouds = objTwo.getJSONObject("sys");

            cloud = String.valueOf(clouds.getDouble("sunset"));

        }
    }

    public void getDescription() throws JSONException, IOException, URISyntaxException {

        getCoordinates(cityNameLocation);

        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude
                + "&lon=" + longitude + "&appid=" + apiKey);

        URL url;

        url = uri.toURL();

        Scanner sc = new Scanner(url.openStream());

        String lines = "";
        while (sc.hasNextLine()) {
            lines += sc.nextLine();

            JSONObject objTwo = new JSONObject(lines);


            descriptions = objTwo.getJSONObject("wind");

            description = descriptions.getDouble("speed");

        }
    }

    public static void main(String[] args) throws InterruptedException, JSONException, IOException, URISyntaxException {


        CurrentCondition currentCondition = new CurrentCondition();

        currentCondition.getTemp();

        currentCondition.getCloud();
        currentCondition.getDescription();

        launch(args);


    }

    ObservableList<String> observableList = new ObservableList<String>() {
        @Override
        public void addListener(ListChangeListener<? super String> listChangeListener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super String> listChangeListener) {

        }

        @Override
        public boolean addAll(String... strings) {
            return false;
        }

        @Override
        public boolean setAll(String... strings) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends String> collection) {
            return false;
        }

        @Override
        public boolean removeAll(String... strings) {
            return false;
        }

        @Override
        public boolean retainAll(String... strings) {
            return false;
        }

        @Override
        public void remove(int i, int i1) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<String> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(String string) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public String get(int index) {
            return null;
        }

        @Override
        public String set(int index, String element) {
            return null;
        }

        @Override
        public void add(int index, String element) {




        }


        @Override
        public String remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<String> listIterator() {
            return null;
        }

        @Override
        public ListIterator<String> listIterator(int index) {
            return null;
        }

        @Override
        public List<String> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener invalidationListener) {

        }

        @Override
        public void removeListener(InvalidationListener invalidationListener) {

        }
    };
    public void onButtonTwoClick(ActionEvent actionEvent) throws JSONException, IOException {

        if (actionEvent.getSource().equals(buttonTwo)) {

            String string = "";


            string = CurrentWeatherAPI.currentWeather();
            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter("Weather.JSON"));
                writer.write(string);

                writer.close();
                textArea.setText("The file has been written to.");

                BufferedReader reader = new BufferedReader(new FileReader("WeatherSQL.sql"));
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }

                textArea.setText(content.toString());

            } catch (IOException e) {
                throw new RuntimeException(e) {

                };
            }
            ;
        }
    }


            public void onButtonClick(ActionEvent actionEvent) throws JSONException, IOException, URISyntaxException {

        if (actionEvent.getSource().equals(button)) {

            temp.setText(temperature.toString());

            weather.setText(cloud);

            descriptionOfWeather.setText(description.toString());

            getCloud2();

            Double num1 = Double.valueOf(cloud);

            getCloud();

            Double num2 = Double.valueOf(cloud);

            Double var = num1 - num2;

            sunriseTime2.setText(String.valueOf(var));

        }
    }



}
