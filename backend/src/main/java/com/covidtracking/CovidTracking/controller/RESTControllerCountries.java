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
@RequestMapping("/api")
public class RESTControllerCountries {

    @Autowired
    public PlaceService service;

    @Autowired
    public HandlingRequestsService handler;

    @GetMapping("/countries")
    public ArrayList<Place> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getAsianCountries();
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

    @GetMapping("/countries/asian")
    public ArrayList<Place> getAsianCountries() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getAsianCountries();
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);     
        }
        return namePlaces;
    }

    @GetMapping("/countries/american")
    public ArrayList<Place> getAmericanPlaces() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getAmericanCountries();
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);     
        }
        return namePlaces;
    }

    @GetMapping("/countries/europe")
    public ArrayList<Place> getEuropeanPlaces() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getEuropeanCountries();
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);     
        }
        return namePlaces;
    }

    @GetMapping("/countries/australia")
    public ArrayList<Place> getOceanicPlaces() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getAustralianCountries();
        if (places == null) {
            return null;
        }
        ArrayList<Place> namePlaces = new ArrayList<>();
        for (Place p : places) {
            namePlaces.add(p);     
        }
        return namePlaces;
    }

    @GetMapping("/countries/africa")
    public ArrayList<Place> getAfricanPlaces() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Place> places = this.service.getAfricanCountries();
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
