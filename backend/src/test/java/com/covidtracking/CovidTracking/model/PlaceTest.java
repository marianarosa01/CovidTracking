package com.covidtracking.CovidTracking.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.covidtracking.CovidTracking.models.Place;

public class PlaceTest {

    Place france = new Place("France", "fra", "Europe", 65533058);

    @Test
    void getPlaceTest() {

        assertEquals("France", france.getCountry());
        assertEquals("fra", france.getIso());
        assertEquals("Europe", france.getContinent());
        assertEquals(65533058, france.getPopulation());
       
    }
}