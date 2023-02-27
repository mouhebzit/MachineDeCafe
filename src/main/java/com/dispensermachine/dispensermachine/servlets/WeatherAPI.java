package com.dispensermachine.dispensermachine.servlets;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.StringReader;

public class WeatherAPI {
    static String weatherApi = "http://api.weatherapi.com/v1/current.json?key=a828157cf1dc4aa2bcb175000230202&q=Paris&aqi=no";
    public static Client client = ClientBuilder.newClient();
    static Response res = client.target(weatherApi).request(MediaType.APPLICATION_JSON).get();
    static JsonObject weatherInfo = Json.createReader(new StringReader(res.readEntity(String.class))).readObject();
    public static double tempC = weatherInfo.getJsonObject("current").getJsonNumber("temp_c").doubleValue();

}
