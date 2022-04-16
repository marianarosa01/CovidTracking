package com.covidtracking.CovidTracking.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.covidtracking.CovidTracking.exception.ResourceNotFoundException;
import com.covidtracking.CovidTracking.models.Place;
import com.covidtracking.CovidTracking.models.Statistics;
import com.covidtracking.CovidTracking.service.HandlingRequestsService;
import com.covidtracking.CovidTracking.service.PlaceService;
import com.covidtracking.CovidTracking.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
public class RESTControllerStatistic {

    @Autowired
    public StatisticsService service;

    @Autowired
    public HandlingRequestsService handler;

    @GetMapping("/world")
    public ArrayList<Statistics> getWorldStatistics() throws ResourceNotFoundException, IOException, URISyntaxException, InterruptedException {
        return service.getStatisticsData();
    }
    @GetMapping("/{country}")
    public Statistics getStatsByCountry(@PathVariable String country) throws ResourceNotFoundException {
        return service.getStatisticsByCountry(country);
    }

}