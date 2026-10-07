package com.example.ovapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class API {

    private String url = "https://gateway.apiportal.ns.nl/reisinformatie-api/api/v3/trips";
    private String key = "2b02c6519038420a84dbf05f596689b0";

    /*
     * To create a connection
     *
     * @param String getParameterKeysAndValues get parameter key and values
     * @return HttpURLConnection connection connection
     */
    private HttpURLConnection connect(String getParameterKeysAndValues) {

        try {

            URL url = new URL(this.url + getParameterKeysAndValues);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", this.key);
            connection.setRequestProperty("Accept", "application/json");

            return connection;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    /*
     * To get the api data based on the get parameter keys and values
     *
     * @param String getParameterKeysAndValues get parameter key and values
     * @return String data api data
     */
    public String get(String getParameterKeysAndValues) {

        try {

            HttpURLConnection connection = this.connect(getParameterKeysAndValues);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String data = reader.lines().collect(Collectors.joining());

            reader.close();

            return data;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
