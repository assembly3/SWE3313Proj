import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class APIconn{

    private static String apiKey;

    static {
        Properties prop = new Properties();
        InputStream input = currentWeatherAPI.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        apiKey = prop.getProperty("api.key");
    }
    public static String getApiKey(){
        return apiKey;
    }
}