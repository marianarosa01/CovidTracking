package com.covidtracking.CovidTracking.repository;

import com.covidtracking.CovidTracking.entities.Place;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Integer> {
    Place findByName(Long id);

}




