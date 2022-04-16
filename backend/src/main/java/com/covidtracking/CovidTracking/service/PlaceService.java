package com.covidtracking.CovidTracking.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;
import com.covidtracking.CovidTracking.models.Place;

@Service
public class PlaceService {
    
    private String endpoint;
    
    private HandlingRequestsService handler;
    
    public ArrayList<Place> getAsianCountries() throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        endpoint = "npm-covid-data/asia";
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Place> asianCountries = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continente = objectJSON.get("Continent").toString();
            String id = objectJSON.get("id").toString();
            String population = objectJSON.get("Population").toString();
            Long pop_long = Long.valueOf(population);

            Place newPlace = new Place(id, country,continente, pop_long);
            
            if (asianCountries.contains(newPlace) == false){
                asianCountries.add(newPlace);
            }

        }
        return asianCountries;

       
    }

    public ArrayList<Place> getEuropeanCountries() throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        endpoint = "npm-covid-data/europe";
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Place> europeanCountries = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continente = objectJSON.get("Continent").toString();
            String id = objectJSON.get("id").toString();
            String population = objectJSON.get("Population").toString();
            Long pop_long = Long.valueOf(population);

            Place newPlace = new Place(id, country,continente, pop_long);
            
            if (europeanCountries.contains(newPlace) == false){
                europeanCountries.add(newPlace);
            }

        }
        return europeanCountries;

       
    }

    public ArrayList<Place> getAmericanCountries() throws IOException, URISyntaxException, InterruptedException {

        HandlingRequestsService handler1 = new HandlingRequestsService();
        String endpoint1 = "npm-covid-data/northamerica";
        String data1 = handler1.connectAPI(endpoint1);
        JSONArray jsonArray1 = new JSONArray(data1);

        String endpoint2 = "npm-covid-data/southamerica";
        String data2 = handler1.connectAPI(endpoint2);
        JSONArray jsonArray2 = new JSONArray(data2);

        for (int i = 0; i < jsonArray1.length(); i++) {
            jsonArray2.put(jsonArray1.getJSONObject(i));
        }
        ArrayList<Place> americanCountries = new ArrayList<>();

        for(int i = 0; i < jsonArray2.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray2.get(i);
            String country = objectJSON.get("Country").toString();
            String continente = objectJSON.get("Continent").toString();
            String id = objectJSON.get("id").toString();
            String population = objectJSON.get("Population").toString();
            Long pop_long = Long.valueOf(population);

            Place newPlace = new Place(id, country,continente, pop_long);
            
            if (americanCountries.contains(newPlace) == false){
                americanCountries.add(newPlace);
            }

        }
        return americanCountries;

    }

    public ArrayList<Place> getAustralianCountries() throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        endpoint = "npm-covid-data/australia";
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Place> australianCountries = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continente = objectJSON.get("Continent").toString();
            String id = objectJSON.get("id").toString();
            String population = objectJSON.get("Population").toString();
            Long pop_long = Long.valueOf(population);

            Place newPlace = new Place(id, country,continente, pop_long);
            
            if (australianCountries.contains(newPlace) == false){
                australianCountries.add(newPlace);
            }

        }
        return australianCountries;

       
    }

    public ArrayList<Place> getAfricanCountries() throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        endpoint = "npm-covid-data/australia";
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Place> africanCountries = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continente = objectJSON.get("Continent").toString();
            String id = objectJSON.get("id").toString();
            String population = objectJSON.get("Population").toString();
            Long pop_long = Long.valueOf(population);

            Place newPlace = new Place(id, country,continente, pop_long);
            
            if (africanCountries.contains(newPlace) == false){
                africanCountries.add(newPlace);
            }

        }
        return africanCountries;

       
    }
/*
    @Autowired 
    private PlaceRepository repository;

    public Place savePlace(Place place) { 
        return repository.save(place); 
    }

    public Place getPlaceByCountryId(Integer id){
        return repository.getById(id); 
    } 

    public List<Place> savePlaces(List<Place> Places) { return repository.saveAll(Places); }

    public List<Place> getPlaces() { return repository.findAll(); }


    public Place getPlaceByID(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Place not found for this id:" + id));
    }

    public Map<String, Boolean> deletePlace(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Place not found for this id:" + id));
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Place updatePlace(int id, Place place) throws ResourceNotFoundException {
        Place existingPlace = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Place not found for this id:" + id));
       
        existingPlace.setCountry(place.getCountry());
        existingPlace.setContinent(place.getContinent());
        return repository.save(existingPlace);
    }
*/



}
  