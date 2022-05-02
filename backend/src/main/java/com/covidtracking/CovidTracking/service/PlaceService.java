package com.covidtracking.CovidTracking.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;

import com.covidtracking.CovidTracking.cache.Cache;
import com.covidtracking.CovidTracking.cache.Status;
import com.covidtracking.CovidTracking.models.Place;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PlaceService {

    private HashMap<String, String> isoMap = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(PlaceService.class);

    Status st = new Status(0, 0);
    

    public ArrayList<Place> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        
        String continentBuilder = "continent_";

        ArrayList<Place> world = new ArrayList<>();
        ArrayList<String> continents = new ArrayList<>();
        continents.add("africa");
        continents.add("northamerica");
        continents.add("southamerica");
        continents.add("australia");
        continents.add("europe");
        continents.add("asia");

        for (String c : continents) {
            Object continentCache = Cache.cacheMap.get(continentBuilder + c);

            if (continentCache == null) {
                world.addAll(getContinentCountries(c));

                log.info(">> [REQUEST] Getting continent countries");
                Cache.cacheMap.put(continentBuilder + c, getContinentCountries(c));
                st.setMiss();
                st.TimerCache(continentBuilder + c);
            }

            else {
                world.addAll((ArrayList<Place>) continentCache);
                log.info(">> [CACHE] Getting continent countries");
            }

        }


        return world;

    }

    public ArrayList<Place> getContinentCountries(String continente)
            throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        String endpoint = "npm-covid-data/" + continente;
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Place> continents = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON = (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continent = objectJSON.get("Continent").toString();
            String population = objectJSON.get("Population").toString();
            String iso = objectJSON.get("ThreeLetterSymbol").toString();
            Integer pop_long = Integer.valueOf(population);

            Place newPlace = new Place(country, iso, continent, pop_long);

            if (continents.contains(newPlace) == false) {
                continents.add(newPlace);
            }

            if (isoMap.containsKey(newPlace.getCountry()) == false) {
                isoMap.put(country, iso);
            }

        }
        return continents;

    }

    public Place getPlaceByCountryName(String country) {
        String countryName = country.substring(0, 1).toUpperCase() + country.substring(1);
        Place selectedCountry = new Place();
        Object placeCache = Cache.cacheMap.get("country_name_" + countryName + "_return_place");
        if (placeCache == null) {
            try {
                ArrayList<Place> world = getAllCountries();

            
                for (Place p : world) {
                    if ( countryName.equals(p.getCountry())) {
                        selectedCountry = p;

                    }

                }

                log.info(">> [REQUEST] Getting place by country name");
                Cache.cacheMap.put("country_name_" + countryName + "_return_place", selectedCountry);
                st.setMiss();
                st.TimerCache("country_name_" + countryName + "_return_place");

            } catch (IOException | URISyntaxException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();

            }
        } 
        else {
            selectedCountry = (Place) placeCache;
            log.info(">> [CACHE] Getting place by country name");

        }

        return selectedCountry;

    }

    public String getIso(String country) {
        String iso = "";
        String isoBuilder = "_iso_";
        String countryBuilder ="country_";
        Object isoCache = Cache.cacheMap.get(countryBuilder + country + isoBuilder);
        if (isoCache == null) {
            try {
                ArrayList<Place> world = getAllCountries();

                iso = isoMap.get(country);

                log.info(">> [REQUEST] Getting iso by country name");
                Cache.cacheMap.put(countryBuilder + country + isoBuilder, iso);
                st.setMiss();
                st.TimerCache(countryBuilder + country + isoBuilder);

            } catch (IOException | URISyntaxException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();

            }
        } else {
            iso = (String) isoCache;
            log.info(">> [CACHE] Getting iso by country name");

        }

        return iso;

    }

}

