package com.covidtracking.CovidTracking.models;

import java.lang.annotation.Inherited;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "statistics")

public class Statistics {
    
    @Id
    private String place;
    private Integer totalCases;
    private Integer newCases;
    private Integer totalDeaths;
    private Integer newDeaths;
    private Integer criticalState;
    private Integer totalRecoveries;
    private Integer newRecoveries;
    private Double infectionRisk;




    public Statistics(String place, Integer totalCases, Integer newCases, Integer totalDeaths, Integer newDeaths, Integer criticalState, Integer newRecoveries, Integer totalRecoveries, Double infectionRisk) {
        this.place = place;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.criticalState = criticalState;
        this.newRecoveries = newRecoveries;
        this.totalRecoveries = totalRecoveries;

        this.infectionRisk = infectionRisk;
    }

    public Double getInfectionRisk() {
        return this.infectionRisk;
    }

    public void setInfectionRisk(Double infectionRisk) {
        this.infectionRisk = infectionRisk;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public Statistics() {
    }



    public Integer getTotalCases() {
        return this.totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getNewCases() {
        return this.newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Integer getTotalDeaths() {
        return this.totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getNewDeaths() {
        return this.newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getCriticalState() {
        return this.criticalState;
    }

    public void setCriticalState(Integer criticalState) {
        this.criticalState = criticalState;
    }


    
    public Integer getTotalRecoveries() {
        return this.totalRecoveries;
    }

    public void setTotalRecoveries(Integer totalRecoveries) {
        this.totalRecoveries = totalRecoveries;
    }

    public Integer getNewRecoveries() {
        return this.newRecoveries;
    }

    public void setNewRecoveries(Integer newRecoveries) {
        this.newRecoveries = newRecoveries;
    }

    @Override
    public String toString() {
        return "{" +
            " place='" + getPlace() + "'" +
            ", totalCases='" + getTotalCases() + "'" +
            ", newCases='" + getNewCases() + "'" +
            ", totalDeaths='" + getTotalDeaths() + "'" +
            ", newDeaths='" + getNewDeaths() + "'" +
            ", criticalState='" + getCriticalState() + "'" +
            "}";
    }

    


}
