package com.covidtracking.CovidTracking.service;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import com.covidtracking.CovidTracking.models.*;

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
        //JSONArray jsonData = new JSONArray(response.body());
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
            System.out.println(c);
            countries.add(c);
        }
        return countries;

       
    }



}/*
        URIBuilder builder = new URIBuilder(url.replaceAll(" ", "%20"));
        String response = constructUrlRequest(builder.build().toString());

        JSONObject responseJson = new JSONObject(response);

        if(responseJson.get("status").toString() == "fail"){
            return null;
        }

        JSONArray data = new JSONArray(responseJson.get("data").toString());

        for (Object obj: data){
            JSONObject jsonObj = (JSONObject) obj;
            if (flag == 0)
                values.add(jsonObj.get("state").toString());
            else
                values.add(jsonObj.get("country").toString());

        }
        return values; */
    


    //tentar 1 endpoint ir buscar os paises
    //controller vai ter serviço --> chamar metodo getData no controller p serviço ir buscar API



    
   

    //System.out.println(response.body());

    //private Cache cache = new Cache(60);

    

