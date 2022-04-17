package com.covidtracking.CovidTracking.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.covidtracking.CovidTracking.models.Place;
import com.covidtracking.CovidTracking.models.Statistics;

@Service
public class StatisticsService {

    private String endpoint;
    private HandlingRequestsService handler;
    private PlaceService placesService = new PlaceService();

    private ArrayList<Statistics> allStats = new ArrayList<>();

    public Statistics getStatsWorld() throws IOException, InterruptedException{
        HandlingRequestsService handler = new HandlingRequestsService();
        endpoint = "npm-covid-data/world";
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        JSONObject obj = (JSONObject) jsonArray.get(0);
        Statistics s = analysing(obj);
        return s;
    }


    public ArrayList<Statistics> getStatisticsData(String country, String iso) throws InterruptedException, IOException {
        HandlingRequestsService handler = new HandlingRequestsService();
       
        if (country == "" && iso == "" ) {
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
            endpoint = "npm-covid-data/country-report-iso-based/" + country + "/" + iso;
            String data2 = handler.connectAPI(endpoint);
            JSONArray jsonArray2 = new JSONArray(data2);
            
            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(i);
                Statistics statCountry = analysing(objectJSONCountry);
                allStats.add(statCountry);
            }
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

    /*
     * 
     * public Statistics getStatisticByCountryId(Long id){
     * return repository.findByPlaceId(id);
     * }
     * 
     * 
     * public Statistics saveStatistic(Statistics st) {
     * return repository.save(st);
     * }
     * 
     * public List<Statistics> saveStatistics(List<Statistics> sts) { return
     * repository.saveAll(sts); }
     * 
     * public List<Statistics> getStatistics() { return repository.findAll(); }
     * 
     * 
     * public Statistics getStatisticByID(int id) throws ResourceNotFoundException {
     * return repository.findById(id)
     * .orElseThrow(() -> new
     * ResourceNotFoundException("Statistic not found for this id:" + id));
     * }
     * 
     * public Map<String, Boolean> deleteStatistic(int id) throws
     * ResourceNotFoundException {
     * repository.findById(id).orElseThrow(() -> new
     * ResourceNotFoundException("Statistic not found for this id:" + id));
     * repository.deleteById(id);
     * Map<String, Boolean> response = new HashMap<>();
     * response.put("deleted", Boolean.TRUE);
     * return response;
     * }
     * 
     * public Statistics updateStatistic(int id, Statistics st) throws
     * ResourceNotFoundException {
     * Statistics existingStatistic = repository.findById(id)
     * .orElseThrow(() -> new
     * ResourceNotFoundException("Statistic not found for this id:" + id));
     * 
     * existingStatistic.setTotalCases(st.getTotalCases());
     * existingStatistic.setNewCases(st.getNewCases());
     * existingStatistic.setTotalDeaths(st.getTotalCases());
     * existingStatistic.setNewDeaths(st.getNewDeaths());
     * existingStatistic.setCriticalState(st.getCriticalState());
     * existingStatistic.setNumberRecoveries(st.getNumberRecoveries());
     * 
     * return repository.save(existingStatistic);
     * }
     * 
     */
}
