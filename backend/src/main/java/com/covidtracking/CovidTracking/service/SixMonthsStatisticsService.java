package com.covidtracking.CovidTracking.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

import com.covidtracking.CovidTracking.models.SixMonthsStatistics;
@Service
public class SixMonthsStatisticsService {
    
    private ArrayList<SixMonthsStatistics> allStats = new ArrayList<>();

    public ArrayList<SixMonthsStatistics> getStatisticsData(String iso) throws InterruptedException, IOException {

        HandlingRequestsService handler = new HandlingRequestsService();
        if (iso.equals("") ) {
            String endpoint = "covid-ovid-data/sixmonth/" ;
            String data = handler.connectAPI(endpoint);
      
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objectJSON = (JSONObject) jsonArray.get(i);
                SixMonthsStatistics stat = analysing(objectJSON);
                if (allStats.contains(stat) == false) {
                    allStats.add(stat);
                }
            }
        }

        else {

            String endpoint = "covid-ovid-data/sixmonth/" + iso;
            String data2 = handler.connectAPI(endpoint);
            JSONArray jsonArray2 = new JSONArray(data2);
            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(i);
                SixMonthsStatistics statCountry = analysing(objectJSONCountry);
                allStats.add(statCountry);
            }
        }

        return allStats;
    }


    public SixMonthsStatistics analysing(JSONObject obj) {

        String country = obj.get("Country").toString();
        String placeId = obj.get("id").toString();
        Integer totalCases = Integer.parseInt(obj.get("total_cases").toString());
        Integer newCases = Integer.parseInt(obj.get("new_cases").toString());
        Integer totalDeaths = Integer.parseInt(obj.get("total_deaths").toString());
        Integer newDeaths = Integer.parseInt(obj.get("new_deaths").toString());
        Integer newTests = Integer.parseInt(obj.get("new_tests").toString());
        Integer totalTests = Integer.parseInt(obj.get("total_tests").toString());
        String date = obj.get("date").toString();

        SixMonthsStatistics stat = new SixMonthsStatistics(placeId, country, totalCases, newCases, totalDeaths, newDeaths,
                totalTests, newTests, date);

        return stat;
    }


}
