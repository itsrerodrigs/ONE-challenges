import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.util.Map;

public class CurrencyAPI {

    private static final String API_KEY = "7a92a9c9042b0a0ed34ac398";

    public static Map<String, Double> getRates(String base) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + base;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                System.out.println("Error fetching rates: HTTP " + conn.getResponseCode());
                return null;
            }

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            Gson gson = new Gson();
            ApiResponse response = gson.fromJson(reader, ApiResponse.class);
            reader.close();
            conn.disconnect();

            return response.conversion_rates;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static class ApiResponse {
        String result;
        String base_code;
        Map<String, Double> conversion_rates;
    }
}
