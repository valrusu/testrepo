import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpsUrlFetcher {
    public static void main(String[] args) {
        try {
            // URL to fetch
            URL url = new URL("https://example.com");

            // Open a connection
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            // Set the request method (GET is the default)
            connection.setRequestMethod("GET");

            // Optional: Set request headers
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Close the connections
            in.close();
            connection.disconnect();

            // Print the content
            System.out.println("Response Content: " + content.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
