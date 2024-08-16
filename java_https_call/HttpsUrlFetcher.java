
/*
javac HttpsUrlFetcher.java
java -cp . HttpsUrlFetcher "https://ics2wstest.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.132.wsdl?WSDL"
java -cp . HttpsUrlFetcher "https://uatttcairrulesdatabase-service.amadeus.com/TTCRulesWS/TTCRulesWS.asmx"
java -cp . HttpsUrlFetcher https://example.com
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpsUrlFetcher {
    public static void main(String[] args) {
        try {
            // URL to fetch
            //URL url = new URL("https://example.com");
            //URL url = new URL("https://ics2wstest.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.132.wsdl?WSDL");
        System.out.println(args[0]);
            URL url = new URL(args[0]);
        System.out.println(url);

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
