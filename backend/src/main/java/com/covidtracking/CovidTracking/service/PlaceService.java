package com.covidtracking.CovidTracking.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;
import com.covidtracking.CovidTracking.models.Place;

@Service
public class PlaceService {
    
    private HandlingRequestsService handler;
    
    public ArrayList<Place> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        
        ArrayList<Place> world = new ArrayList<>();
        System.out.println("worlddddddddddddddddd");

        ArrayList<Place> africa = getContinentCountries("africa");
        ArrayList<Place> america =  getContinentCountries("northamerica");
        ArrayList<Place> america2 =  getContinentCountries("southamerica");
        ArrayList<Place> australia =  getContinentCountries("australia");
        ArrayList<Place> europe = getContinentCountries("europe");
        ArrayList<Place> asia = getContinentCountries("asia");
        System.out.println(world);
        world.addAll(africa);
        world.addAll(america);
        world.addAll(america2);
        world.addAll(europe);
        System.out.println(world);

        world.addAll(asia);
        world.addAll(australia);

        System.out.println(world);
        return world;

    }
    
    
    public ArrayList<Place> getContinentCountries(String continente) throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        String endpoint = "npm-covid-data/" + continente; 
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Place> continents = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continent = objectJSON.get("Continent").toString();
            String id = objectJSON.get("id").toString();
            String population = objectJSON.get("Population").toString();
            String iso =  objectJSON.get("ThreeLetterSymbol").toString();
            Long pop_long = Long.valueOf(population);

            Place newPlace = new Place(id, country, iso,continent, pop_long);
            
            if (continents.contains(newPlace) == false){
                continents.add(newPlace);
            }


        }
        return continents;

       
    }


    public Place getPlaceByCountryName(String country){

        Place selectedCountry = new Place();
        System.out.println("here");
        try {
			ArrayList<Place> world = getAllCountries();
            System.out.println("hi");
            System.out.println(world);
            for (Place p : world) {
                if (p.getCountry() == country){
                    selectedCountry = p;
                    System.out.println("A RESPOSTA E");
                    System.out.println(selectedCountry);

                }
            } 
		} catch (IOException | URISyntaxException | InterruptedException e) {
			e.printStackTrace();
		}
        
		return selectedCountry;

    }

   
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



