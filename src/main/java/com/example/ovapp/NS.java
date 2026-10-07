package com.example.ovapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.example.ovapp.API;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NS extends API {

    private JsonObject dataObject;

    public NS(String from, String to) {

        this.dataObject = JsonParser.parseString(this.get("?fromStation=" + from + "&toStation=" + to + "&dateTime=" + LocalDateTime.now())).getAsJsonObject();
    }

    /*
     * To get the origin time (time of departure)
     *
     * @return string array list
     */
    public ArrayList<String> getOriginTime() {

        return this.getTripLegData("origin", "plannedDateTime");
    }

    /*
     * To get the destination time (time of arrival)
     *
     * @return string array list
     */
    public ArrayList<String> getDestinationTime() {

        return this.getTripLegData("destination", "plannedDateTime");
    }

    /*
     * To get the type of train
     *
     * @return string array list
     */
    public ArrayList<String> getTrainType() {

        return this.getTripLegData("product", "longCategoryName");
    }

    /*
     * To get the trip leg data based on key and subkey
     *
     * @param String key leg key
     * @param String subkey leg sub key
     * @return string array list data trip leg data based on key and subkey
     */
    private ArrayList<String> getTripLegData(String key, String subKey) {

        JsonArray trips = this.dataObject.getAsJsonArray("trips");

        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            JsonObject trip = trips.get(i).getAsJsonObject();
            JsonArray legs = trip.getAsJsonArray("legs");

            JsonObject object = legs.get(0).getAsJsonObject().getAsJsonObject(key);

            String value = object.get(subKey).getAsString();

            if(subKey.equals("plannedDateTime") == true) {

                data.add(value.substring(11, 16));
            } else {
                data.add(value);
            }
        }

        return data;
    }
}
