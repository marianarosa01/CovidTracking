package com.covidtracking.CovidTracking.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONObject;

@Service
public class HandlingRequestsService {
 
    String apiKey = "54694a148fmsh965792128cff380p11824ajsn42438a73c35d";
    String apiURL = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/";
    String apiHost = "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com";
    String endpoint;

    private CloseableHttpClient client;

    public String connectAPI(String endpoint) throws IOException, InterruptedException {
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiURL + endpoint))
            .header("X-RapidAPI-Host", apiHost)
            .header("X-RapidAPI-Key", apiKey)
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
        
    }

    public HandlingRequestsService() throws InterruptedException {
        this.client = HttpClients.createDefault();
    }

    public ArrayList<String> getCountries() throws IOException, URISyntaxException, InterruptedException {
        endpoint = "npm-covid-data/countries-name-ordered";
        String data = connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<String> countries = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String c = objectJSON.get("Country").toString();
            countries.add(c);
        }
        return countries;

       
    }



}