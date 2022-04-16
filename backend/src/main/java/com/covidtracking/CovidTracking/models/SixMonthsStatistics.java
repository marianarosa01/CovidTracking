package com.covidtracking.CovidTracking.models;

import java.lang.annotation.Inherited;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "sixmonthstats")
public class SixMonthsStatistics {
    


    @Id
    private Long sixPlaceId;
    private Long six_totalCases;
    private Long six_newCases;
    private Long six_otalDeaths;
    private Long six_newDeaths;
    private Long six_criticalState;
    private Long six_numberRecoveries;
    private Date date;

    public SixMonthsStatistics(){        
    }

    public SixMonthsStatistics(Long six_placeId, Long six_totalCases, Long six_newCases, Long six_otalDeaths, Long six_newDeaths, Long six_criticalState, Long six_numberRecoveries, Date date) {
        this.sixPlaceId = six_placeId;
        this.six_totalCases = six_totalCases;
        this.six_newCases = six_newCases;
        this.six_otalDeaths = six_otalDeaths;
        this.six_newDeaths = six_newDeaths;
        this.six_criticalState = six_criticalState;
        this.six_numberRecoveries = six_numberRecoveries;
        this.date = date;
    }


    public Long getSix_placeId() {
        return this.sixPlaceId;
    }

    public void setSix_placeId(Long six_placeId) {
        this.sixPlaceId = six_placeId;
    }

    public Long getSix_totalCases() {
        return this.six_totalCases;
    }

    public void setSix_totalCases(Long six_totalCases) {
        this.six_totalCases = six_totalCases;
    }

    public Long getSix_newCases() {
        return this.six_newCases;
    }

    public void setSix_newCases(Long six_newCases) {
        this.six_newCases = six_newCases;
    }

    public Long getSix_otalDeaths() {
        return this.six_otalDeaths;
    }

    public void setSix_otalDeaths(Long six_otalDeaths) {
        this.six_otalDeaths = six_otalDeaths;
    }

    public Long getSix_newDeaths() {
        return this.six_newDeaths;
    }

    public void setSix_newDeaths(Long six_newDeaths) {
        this.six_newDeaths = six_newDeaths;
    }

    public Long getSix_criticalState() {
        return this.six_criticalState;
    }

    public void setSix_criticalState(Long six_criticalState) {
        this.six_criticalState = six_criticalState;
    }

    public Long getSix_numberRecoveries() {
        return this.six_numberRecoveries;
    }

    public void setSix_numberRecoveries(Long six_numberRecoveries) {
        this.six_numberRecoveries = six_numberRecoveries;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  

    

}

