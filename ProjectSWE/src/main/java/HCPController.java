import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HCPController {
    @FXML
    public TextArea textAreaOne;
    @FXML
    public TextArea textAreaTwo;
    @FXML
    public Button button;
    @FXML
    public TextField textField;
    @FXML
    public Button buttonTwo;

    String string;

    public TextArea getTextAreaOne() {
        return this.textAreaOne;
    }

    public TextArea getTextAreaTwo() {
        return this.textAreaTwo;
    }

    public void onHelloButtonClick(ActionEvent actionEvent) throws InterruptedException {

        if (actionEvent.getSource() == button) {

            CovidNineteen covidNineteen = new CovidNineteen();

            covidNineteen.main();

        }

    }

    public void onHelloButtonClick2(ActionEvent actionEvent) {

        if (actionEvent.getSource() == buttonTwo) {


            CovidNineteenThread sync = new CovidNineteenThread();

            sync.sync();


        }

    }

    public class CovidNineteen {

        public static int counter = 0;

        public static int counter() {

            counter = counter + 1;

            return counter;
        }


        public static Thread[] myArray = new Thread[14];

        public static int integer = 0;

        static String responseBody = "";


        public Thread[] covid19ResponseThread() throws InterruptedException {


            do {

                myThread thread = new myThread("CovidThread" + integer);
                myArray[integer] = thread;

                integer = integer + 1;


            } while (integer < 14);


            return myArray;
        }


        class myThread extends Thread {

            public myThread(String s) {

            }

            @Override
            public void run() {


                HCP.setStr(CovidNineteenThread.covid19Response(counter()));

                getTextAreaOne().setEditable(true);
                getTextAreaOne().setText(HCP.getStr());

            }

        }

        public void main() throws InterruptedException {

            Thread[] myArrayThread = new Thread[14];

            myArrayThread = covid19ResponseThread();

            for (Thread threadObject : myArrayThread) {


                threadObject.start();


            }
        }

    }

    public class CovidNineteenThread {
        public static HttpClient httpClient = HttpClient.newHttpClient();
        public static Double[] myArray = new Double[14];

        static String string;

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

                System.out.println(sum + " vaccines identified within the past " + i + " days." + "\n");

            }

            return sum;

        }

         public void sync() {


            int counter;

            for (counter = 0; counter <= 1; counter++) {

                MyThreadCovid thread = new MyThreadCovid("Child number" + counter, counter);

                thread.thrd.start();


                try {
                    thread.thrd.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }



        class MyThreadCovid implements Runnable {
            Thread thrd;

            static int counter = 0;
            public CovidNineteenThread covidNineteenThread = new CovidNineteenThread();
            Thread[] threadArray = new Thread[14];

            MyThreadCovid(String name, int integer) {
                thrd = new Thread(this, name);
                threadArray[integer] = thrd;

            }

            @Override
            public void run() {

                Double sum;

                sum = covidNineteenThread.totalVaccines();

                // string = sum + " covid-19 vaccines detected within the past 14 " + "days.";


                getTextAreaTwo().setEditable(true);

                getTextAreaTwo().setText(sum + " covid-19 vaccines distributed within the past 14 " + "days.");



            }





        }
    }

}



