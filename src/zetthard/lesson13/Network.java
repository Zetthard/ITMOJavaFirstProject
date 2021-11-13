package zetthard.lesson13;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {

    private static HttpURLConnection connection;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста, введите ваш запрос: ");
        String key = sc.nextLine();
        sc.close();
        String query = generateQuery(key);
        URL url = new URL(query);

        connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();

        InputStream input = connection.getInputStream();
        String contentAsString = new String(input.readAllBytes(), StandardCharsets.UTF_8);

        Gson gson = new Gson();
        ResponseDTO result = gson.fromJson(contentAsString, ResponseDTO.class);
        System.out.println();
        
        List<SearchDTO> searchList = result.getQuery().getSearch();
        List<String> output = new ArrayList<>();

        for (SearchDTO s : searchList) {
            output.add(s.getSnippet());
        }
        System.out.println("Results:");

        for (String ans :
                output) {
            System.out.println(ans + "/n");
            System.out.println();
        }
    }

    private static String generateQuery(String key) {
        return String.format("https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=%s",
                URLEncoder.encode(key, StandardCharsets.UTF_8));
    }

    class ResponseDTO {
        @SerializedName("query")
        private QueryDTO query;

        public QueryDTO getQuery() {
            return query;
        }
    }

    class QueryDTO {
        @SerializedName("search")
        private List<SearchDTO> search;

        public List<SearchDTO> getSearch() {
            return search;
        }
    }

    class SearchDTO {
        @SerializedName("snippet")
        private String snippet;

        public String getSnippet() {
            return snippet;
        }
    }
}
