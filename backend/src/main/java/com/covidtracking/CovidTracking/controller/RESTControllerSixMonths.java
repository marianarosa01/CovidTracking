package com.covidtracking.CovidTracking.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.covidtracking.CovidTracking.exception.ResourceNotFoundException;
import com.covidtracking.CovidTracking.models.SixMonthsStatistics;
import com.covidtracking.CovidTracking.models.Statistics;
import com.covidtracking.CovidTracking.service.HandlingRequestsService;
import com.covidtracking.CovidTracking.service.SixMonthsStatisticsService;
import com.covidtracking.CovidTracking.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sixmonths/stats")
public class RESTControllerSixMonths {

    @Autowired
    public SixMonthsStatisticsService service;

    @Autowired
    public HandlingRequestsService handler;


    @GetMapping("/world")
    public ArrayList<SixMonthsStatistics> getWorldStatistics() throws ResourceNotFoundException, IOException, URISyntaxException, InterruptedException {
        return service.getStatisticsData("");
    }

    @GetMapping("/{iso}")
    public ArrayList<SixMonthsStatistics> getCountriesStatistics(@PathVariable String iso) throws ResourceNotFoundException, IOException, URISyntaxException, InterruptedException {
        return service.getStatisticsData(iso);
    }


   

}