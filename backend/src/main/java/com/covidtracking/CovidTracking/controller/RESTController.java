package com.covidtracking.CovidTracking.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.covidtracking.CovidTracking.cache.Status;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RESTController {

    @Autowired
    public StatisticsService service;

    @Autowired
    public HandlingRequestsService handler;

    @Autowired
    public PlaceService servicePlace;

    Status st = new Status(0, 0);

    @GetMapping("/api/statistics/world")
    public Statistics getWorldStatistics()
            throws ResourceNotFoundException, IOException, URISyntaxException, InterruptedException {
        return service.getStatsWorld();
    }

    @GetMapping("/api/statistics/countries")
    public ArrayList<Statistics> getCountriesStatistics()
            throws ResourceNotFoundException, IOException, URISyntaxException, InterruptedException {
                return service.getStatisticsData("");
    }

    @GetMapping("/api/statistics/{country}/")
    public ArrayList<Statistics> getStatsByCountry(@PathVariable(value = "country") String country)
            throws ResourceNotFoundException, InterruptedException, IOException {
        return service.getStatisticsData(country);
    }


    @GetMapping("/api/countries/all")
    public ArrayList<Place> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("AAAAa");
        ArrayList<Place> places = servicePlace.getAllCountries();
        System.out.println(places);
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);

        }
        return namePlaces;

    }

    @GetMapping("/api/countries/{con}")
    public ArrayList<Place> getCountriesByContinent(@PathVariable String con)
            throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = servicePlace.getContinentCountries(con);
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);
        }
        return namePlaces;
    }
    
    @GetMapping("/api/{country}")
    public Place getPlaceByCountry(@PathVariable String country)
            throws IOException, URISyntaxException, InterruptedException {
        Place place = servicePlace.getPlaceByCountryName(country);
        if (place == null) {
            return null;
        }

        else{
            return place;

        }
    }

    

    @RequestMapping("/api/cache")
    public Object getCacheStatistics() {
        return st.toString();
    }
}


