package com.covidtracking.CovidTracking.controller;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.covidtracking.CovidTracking.models.Place;
import com.covidtracking.CovidTracking.models.Statistics;
import com.covidtracking.CovidTracking.service.PlaceService;
import com.covidtracking.CovidTracking.service.StatisticsService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StatisticsService service;

    @MockBean
    private PlaceService placeService;


    @Test
    void getWorldDataTest() throws Exception {
        Statistics worldData = new Statistics("World",507955550,255334,6237108,933,41733,459875123,907573, 0.0);

        when( service.getStatsWorld() ).thenReturn( worldData );

        mvc.perform(
            get("/api/statistics/world").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(9)))
            .andExpect(jsonPath("$.place", is(worldData.getPlace()))
        );
            
        verify(service, times(1)).getStatsWorld();
    }

    @Test
    void getWorldStatisticsTest() throws Exception {
        ArrayList<Statistics> stat = new ArrayList<>();

        //lets suppose the world has these 2 places with these statistics
        Statistics franceStats = new Statistics("France", 7845245, 14548, 7845512, 56, 488954, 11235, 785200, 7.85);
        Statistics brasilStats = new Statistics("Brazil", 1225445, 48481, 123358788, 8855, 54454, 111555, 87455265,9.85);

        stat.add(franceStats);
        stat.add(brasilStats);

        when( service.getStatisticsData("") ).thenReturn( stat );

        mvc.perform(
            get("/api/statistics/countries").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(2)))
            .andExpect(jsonPath("$[0].place", is(franceStats.getPlace())))
            .andExpect(jsonPath("$[1].place", is(brasilStats.getPlace())));
            
        verify(service, times(1)).getStatisticsData("");
    }
    @Test
    void getCountryDataTest() throws Exception {
        ArrayList<Statistics> statArray = new ArrayList<>();

        Statistics countryData = new Statistics("Croatia", 507958164, 257947, 623474, 30, 7845, 604877, 4522, 0.5);

        statArray.add(countryData);
        
        when( service.getStatisticsData( Mockito.anyString() ) ).thenReturn( statArray );

        mvc.perform(
            get("/api/statistics/Croatia/").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(1)))
            .andExpect(jsonPath("$[0].place", is(countryData.getPlace())));
            
        verify(service, times(1)).getStatisticsData("Croatia");

    }

    @Test
    void getAllCountriesTest() throws Exception {
        ArrayList<Place> placesArray = new ArrayList<>();

        //let's suppose that the world only has these 3 countries

        Place france = new Place("France", "fra", "Europe", 65533058);
        Place brasil = new Place("Brazil", "bra", "South America", 215274575);
        Place croatia = new Place("Croatia", "hrv", "Europe", 4059781);

        placesArray.add(france);
        placesArray.add(brasil);
        placesArray.add(croatia);

        
        when( placeService.getAllCountries()).thenReturn( placesArray );

        mvc.perform(
            get("/api/countries/all/").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(3)))
            .andExpect(jsonPath("$[0].iso", is("fra")))
            .andExpect(jsonPath("$[0].country", is("France")))
            .andExpect(jsonPath("$[1].iso", is("bra")))
            .andExpect(jsonPath("$[2].iso", is("hrv")));

            
            
        verify(placeService, times(1)).getAllCountries();

    }


    @Test
    void getCountriesByContinentTest() throws Exception {
        ArrayList<Place> placesArray = new ArrayList<>();

        //let's suppose that the world only has these 2 countries in Europe

        Place france = new Place("France", "fra", "Europe", 65533058);
        Place croatia = new Place("Croatia", "hrv", "Europe", 4059781);

        placesArray.add(france);
        placesArray.add(croatia);

        when( placeService.getContinentCountries("europe")).thenReturn(placesArray);

        mvc.perform(
            get("/api/countries/europe/").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(2)))
            .andExpect(jsonPath("$[0].continent", is("Europe")))
            .andExpect(jsonPath("$[1].continent", is("Europe")));


            
            
        verify(placeService, times(1)).getContinentCountries("europe");

    }
}
