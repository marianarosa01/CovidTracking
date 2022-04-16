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

    private ArrayList <Statistics> allStats = new ArrayList<>();
    
    public ArrayList <Statistics> getStatisticsData() throws InterruptedException, IOException {
        HandlingRequestsService handler = new HandlingRequestsService();
        endpoint = "npm-covid-data/countries";

        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);

            //get the country
            String country = objectJSON.get("Country").toString();
            Place p = placesService.getPlaceByCountryName(country);
            
            Integer totalCases = Integer.parseInt(objectJSON.get("TotalCases").toString());
            Integer newCases = Integer.parseInt(objectJSON.get("NewCases").toString());
            Integer totalDeaths = Integer.parseInt(objectJSON.get("TotalDeaths").toString());
            Integer newDeaths =  Integer.parseInt(objectJSON.get("NewDeaths").toString());
            Integer criticalState =  Integer.parseInt(objectJSON.get("Serious_Critical").toString());
            Integer newRecovered = Integer.parseInt(objectJSON.get("NewRecovered").toString());
            Integer totalRecovered = Integer.parseInt(objectJSON.get("TotalRecovered").toString());
            Double infectionRisk = Double.parseDouble(objectJSON.get("Infection_Risk").toString());

            Statistics stat = new Statistics(p, totalCases,newCases, totalDeaths, newDeaths, criticalState, newRecovered, totalRecovered, infectionRisk);

            System.out.println(stat);
            if (allStats.contains(stat) == false){
                allStats.add(stat);
            }

        }
        return allStats;
    }

    public Statistics getStatisticsByCountry(String country) {
        Statistics result = new Statistics();
        try {
			allStats = getStatisticsData();
                    for (Statistics s : allStats) {
                        if (s.getPlace().getCountry() == country){
                            result = s;
                        }
                    }
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
        return result;

        
    }

    /*

    public Statistics getStatisticByCountryId(Long id){
        return repository.findByPlaceId(id); 
    }


    public Statistics saveStatistic(Statistics st) { 
        return repository.save(st); 
    }

    public List<Statistics> saveStatistics(List<Statistics> sts) { return repository.saveAll(sts); }

    public List<Statistics> getStatistics() { return repository.findAll(); }


    public Statistics getStatisticByID(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Statistic not found for this id:" + id));
    }

    public Map<String, Boolean> deleteStatistic(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Statistic not found for this id:" + id));
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Statistics updateStatistic(int id, Statistics st) throws ResourceNotFoundException {
        Statistics existingStatistic = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Statistic not found for this id:" + id));
       
        existingStatistic.setTotalCases(st.getTotalCases());
        existingStatistic.setNewCases(st.getNewCases());
        existingStatistic.setTotalDeaths(st.getTotalCases());
        existingStatistic.setNewDeaths(st.getNewDeaths());
        existingStatistic.setCriticalState(st.getCriticalState());
        existingStatistic.setNumberRecoveries(st.getNumberRecoveries());

        return repository.save(existingStatistic);
    }

 */
}
