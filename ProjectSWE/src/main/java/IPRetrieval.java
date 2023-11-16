import org.json.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class IPRetrieval extends Thread{

    public static String timeZone;

    public static String country_Code;

    public static String cityName;

    public static String latitude;

    public static String longitude;

    public IPRetrieval() {

    }

    @Override
    public void run() {

        try {

                URI uri = new URI("https://get.geojs.io/v1/ip/geo.json");

                URL url;

                url = uri.toURL();

                Scanner sc = new Scanner(url.openStream());

                StringBuilder lines = new StringBuilder();
                while (sc.hasNextLine()) {
                    lines.append(sc.nextLine());
                }

                System.out.println(lines);

                JSONObject obj = new JSONObject(lines.toString());

                timeZone = obj.getString("timezone");

                country_Code = obj.getString("country_code");

                cityName = obj.getString("city");

                latitude = obj.getString("latitude");

                longitude = obj.getString("longitude");

                System.out.println(timeZone + " " + country_Code + " " + cityName + " " +
                        latitude + " " + longitude);

            } catch (JSONException | URISyntaxException | IOException ex) {

                System.out.println(ex.getMessage());

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new IPRetrieval());

        t1.start();
        sleep(5000);
        t1.interrupt();

    }

}
