package com.covidtracking.CovidTracking.models;

import java.lang.annotation.Inherited;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "statistics")

public class Statistics {
    
    @Id
    private Long placeId;
    private Long totalCases;
    private Long newCases;
    private Long totalDeaths;
    private Long newDeaths;
    private Long criticalState;
    private Long numberRecoveries;



    public Statistics(Long placeId, Long totalCases, Long newCases, Long totalDeaths, Long newDeaths, Long criticalState, Long numberRecoveries) {
        this.placeId = placeId;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.criticalState = criticalState;
        this.numberRecoveries = numberRecoveries;
    }

    @OneToOne(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private Place place;

    
    public Statistics() {
    }


    public Long getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getTotalCases() {
        return this.totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public Long getNewCases() {
        return this.newCases;
    }

    public void setNewCases(Long newCases) {
        this.newCases = newCases;
    }

    public Long getTotalDeaths() {
        return this.totalDeaths;
    }

    public void setTotalDeaths(Long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Long getNewDeaths() {
        return this.newDeaths;
    }

    public void setNewDeaths(Long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Long getCriticalState() {
        return this.criticalState;
    }

    public void setCriticalState(Long criticalState) {
        this.criticalState = criticalState;
    }

    public Long getNumberRecoveries() {
        return this.numberRecoveries;
    }

    public void setNumberRecoveries(Long numberRecoveries) {
        this.numberRecoveries = numberRecoveries;
    }


    @Override
    public String toString() {
        return "{" +
            " placeId='" + getPlaceId() + "'" +
            ", totalCases='" + getTotalCases() + "'" +
            ", newCases='" + getNewCases() + "'" +
            ", totalDeaths='" + getTotalDeaths() + "'" +
            ", newDeaths='" + getNewDeaths() + "'" +
            ", criticalState='" + getCriticalState() + "'" +
            ", numberRecoveries='" + getNumberRecoveries() + "'" +
            "}";
    }

    


}
