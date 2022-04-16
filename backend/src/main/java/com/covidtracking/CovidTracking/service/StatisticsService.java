/* package com.covidtracking.CovidTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.covidtracking.CovidTracking.exception.ResourceNotFoundException;
import com.covidtracking.CovidTracking.models.Statistics;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository repository; 


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

 
}*/