package com.covidtracking.CovidTracking.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.covidtracking.CovidTracking.models.Place;
import com.covidtracking.CovidTracking.service.HandlingRequestsService;
import com.covidtracking.CovidTracking.service.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class RESTControllerCountries {

    @Autowired
    public PlaceService service;

    @Autowired
    public HandlingRequestsService handler;

    @GetMapping("/all")
    public ArrayList<Place> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("AAAAa");
        ArrayList<Place> places = this.service.getAllCountries();
        System.out.println(places);
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);
            /*
             * for(Place p: places){
             * nomesCidades.add(cidade.getName());
             * }
             */
        }
        return namePlaces;

    }

    @GetMapping("/{con}")
    public ArrayList<Place> getCountriesByContinent(@PathVariable String con) throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getContinentCountries(con);
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);     
        }
        return namePlaces;
    }

    
    

}
