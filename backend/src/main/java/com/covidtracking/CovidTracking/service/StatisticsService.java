package com.covidtracking.CovidTracking.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.covidtracking.CovidTracking.cache.Cache;
import com.covidtracking.CovidTracking.cache.Status;
import com.covidtracking.CovidTracking.models.Statistics;

@Service
public class StatisticsService {

    private String endpoint;
    private HandlingRequestsService handler;
    private PlaceService placesService = new PlaceService();
    private static final Logger log = LoggerFactory.getLogger(PlaceService.class);
    Status st = new Status(0, 0);

    private ArrayList<Statistics> allStats = new ArrayList<>();

    public Statistics getStatsWorld() throws IOException, InterruptedException {

        //corrigir cache
        Object statsWorld = Cache.cacheMap.get("world_statistics");
        Statistics s;

        if (statsWorld == null) {
            HandlingRequestsService handler = new HandlingRequestsService();
            endpoint = "npm-covid-data/world";
            String data = handler.connectAPI(endpoint);
            JSONArray jsonArray = new JSONArray(data);
            JSONObject obj = (JSONObject) jsonArray.get(0);
            s = analysing(obj);
            log.info(">> [REQUEST] Getting world stats");
            Cache.cacheMap.put("world_statistics", s);
            st.setMiss();
            st.TimerCache("world_statistics");
        
        } else {
            s = (Statistics) statsWorld;
            log.info(">> [CACHE] Getting world stats");

        }
       

       

        return s;
    }

    public ArrayList<Statistics> getStatisticsData(String country) throws InterruptedException, IOException {
        allStats.clear();
        HandlingRequestsService handler = new HandlingRequestsService();
       
        if (country == "" ) {
            endpoint = "npm-covid-data/countries/";
            String data = handler.connectAPI(endpoint);
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objectJSON = (JSONObject) jsonArray.get(i);
                Statistics stat = analysing(objectJSON);
                if (allStats.contains(stat) == false) {
                    allStats.add(stat);
                }
            }
        }

        else {

            Object statsCountry = Cache.cacheMap.get("country_"+ country + "_statistics");

            if (statsCountry == null){
                allStats.clear();

                String isoCountry = placesService.getIso(country);
                endpoint = "npm-covid-data/country-report-iso-based/" + country + "/" + isoCountry;
                String data2 = handler.connectAPI(endpoint);
                JSONArray jsonArray2 = new JSONArray(data2);
                Statistics statCountry;
                for (int i = 0; i < jsonArray2.length(); i++) {
                    JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(i);
                    statCountry = analysing(objectJSONCountry);
                    allStats.add(statCountry);
                    Cache.cacheMap.put("country_"+ country + "_statistics", statCountry);
                }
                
                log.info(">> [REQUEST] Getting country statistics");
                st.setMiss();
                st.TimerCache("country_"+ country + "_statistics");
            }
            else{
                allStats.clear();
                System.out.println("dsa");
                System.out.println(statsCountry);
                allStats.add((Statistics) statsCountry);
                log.info(">> [CACHE] Getting country statistics");
            }
            System.out.println(allStats);
            System.out.println("hahaha");
        }

        return allStats;
    }

  

    public Statistics analysing(JSONObject obj) {

        String country = obj.get("Country").toString();
        Integer totalCases = Integer.parseInt(obj.get("TotalCases").toString());
        Integer newCases = Integer.parseInt(obj.get("NewCases").toString());
        Integer totalDeaths = Integer.parseInt(obj.get("TotalDeaths").toString());
        Integer newDeaths = Integer.parseInt(obj.get("NewDeaths").toString());
        Integer criticalState = Integer.parseInt(obj.get("Serious_Critical").toString());
        Integer newRecovered = Integer.parseInt(obj.get("NewRecovered").toString());
        Integer totalRecovered = Integer.parseInt(obj.get("TotalRecovered").toString());
        Double infectionRisk = Double.parseDouble(obj.get("Infection_Risk").toString());

        Statistics stat = new Statistics(country, totalCases, newCases, totalDeaths, newDeaths, criticalState,
                newRecovered, totalRecovered, infectionRisk);
        return stat;
    }

}
