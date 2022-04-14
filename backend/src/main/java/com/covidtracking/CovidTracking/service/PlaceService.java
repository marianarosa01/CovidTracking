/* package com.covidtracking.CovidTracking.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidtracking.CovidTracking.entities.Place;
import com.covidtracking.CovidTracking.repository.PlaceRepository;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository rep;

    public PlaceService(PlaceRepository rep ){
        this.rep = rep;
    }

    public Place getPlaceById(Long id){
        return rep.findByName(id); //change this
    }

    public void savePlace (Place place){rep.save(place);}



}
 */