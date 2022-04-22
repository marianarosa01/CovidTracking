package com.covidtracking.CovidTracking.model;

import com.covidtracking.CovidTracking.models.Statistics;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatisticTest {

    @Test
    void getStatisticsTest(){
    
    Statistics franceStats = new Statistics("France", 7845245, 14548, 7845512, 56, 488954, 11235, 785200, 7.85);

    assertEquals("France", franceStats.getPlace());
    assertEquals(7845245, franceStats.getTotalCases());
    assertEquals(14548, franceStats.getNewCases());
    assertEquals(56, franceStats.getNewDeaths());
    assertEquals(7845512, franceStats.getTotalDeaths());
    assertEquals(488954, franceStats.getCriticalState());
    assertEquals(11235, franceStats.getNewRecoveries());
    assertEquals(785200, franceStats.getTotalRecoveries());
    assertEquals(7.85, franceStats.getInfectionRisk());
   

    }
}

