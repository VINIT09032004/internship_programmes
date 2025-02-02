package internship_programmes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class SimpleWebScraper {
    public static void main(String[] args) {
        String url = "https://example.com"; // Replace with the URL you want to scrape

        try {
            // Fetch HTML content from the URL
            String htmlContent = fetchHtmlContent(url);

            // Extract and print the title of the webpage
            String title = extractTitle(htmlContent);
            System.out.println("Title: " + title);

            // Extract and print all links from the webpage
            System.out.println("\nLinks:");
            List<String> links = extractLinks(htmlContent);
            for (String link : links) {
                System.out.println(link);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch HTML content from a URL
    private static String fetchHtmlContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    // Method to extract the title from HTML content
    private static String extractTitle(String htmlContent) {
        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "No title found";
    }

    // Method to extract all links from HTML content
    private static List<String> extractLinks(String htmlContent) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);

        while (matcher.find()) {
            links.add(matcher.group(1));
        }

        return links;
    }
}
