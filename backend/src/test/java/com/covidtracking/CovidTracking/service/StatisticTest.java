package com.covidtracking.CovidTracking.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockJspWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.covidtracking.CovidTracking.cache.Cache;
import com.covidtracking.CovidTracking.models.Statistics;

import org.json.JSONException;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class StatisticTest {
    @Mock
    private Cache cache;

    @Mock
    private HandlingRequestsService handler;



    @InjectMocks
    private StatisticsService service;
/* 
    @Test
    void getStatsWorldTest() throws IOException, InterruptedException {

        Statistics worldData = new Statistics("World",507955550,255334,6237108,933,41733,459875123,907573, 0.0);
        Mockito.when(handler.connectAPI(Mockito.anyString())).thenReturn( worldData.toString() );

        Statistics info = service.getStatsWorld(); 
        
        System.out.println(worldData);
        System.out.print(info);
        assertEquals(worldData.toString(), info.toString());
       
    } */

/*     @Test
    void getCountryStatsTest() throws IOException, InterruptedException {

        Statistics countryData = new Statistics("Croatia", 507958164, 257947, 623474, 30, 7845, 604877, 4522, 0.5);

        Mockito.when( handler.connectAPI( Mockito.anyString() ) ).thenReturn( "["+ countryData.toString() +"]" );

        String countryname = countryData.getPlace();

        ArrayList<Statistics> info = service.getStatisticsData(countryname);

        assertEquals(countryData.toString(), info.toString());
       
    } */


    
}
