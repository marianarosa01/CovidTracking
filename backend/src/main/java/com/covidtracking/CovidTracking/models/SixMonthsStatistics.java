package com.covidtracking.CovidTracking.models;

import javax.persistence.*;

@Entity
@Table(name = "sixmonthstats")
public class SixMonthsStatistics {
    


    @Id
    private String sixPlaceId;
    private String country;
    private Integer six_totalCases;
    private Integer six_newCases;
    private Integer six_totalDeaths;
    private Integer six_newDeaths;
    private Integer six_total_tests;
    private Integer six_new_tests;
    private String date;

    public SixMonthsStatistics(String sixPlaceId, String country, Integer six_totalCases, Integer six_newCases, Integer six_totalDeaths, Integer six_newDeaths, Integer six_total_tests, Integer six_new_tests, String date) {
        this.sixPlaceId = sixPlaceId;
        this.country = country;
        this.six_totalCases = six_totalCases;
        this.six_newCases = six_newCases;
        this.six_totalDeaths = six_totalDeaths;
        this.six_newDeaths = six_newDeaths;
        this.six_total_tests = six_total_tests;
        this.six_new_tests = six_new_tests;
        this.date = date;
    }


    public String getSixPlaceId() {
        return this.sixPlaceId;
    }

    public void setSixPlaceId(String sixPlaceId) {
        this.sixPlaceId = sixPlaceId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSix_totalCases() {
        return this.six_totalCases;
    }

    public void setSix_totalCases(Integer six_totalCases) {
        this.six_totalCases = six_totalCases;
    }

    public Integer getSix_newCases() {
        return this.six_newCases;
    }

    public void setSix_newCases(Integer six_newCases) {
        this.six_newCases = six_newCases;
    }

    public Integer getSix_totalDeaths() {
        return this.six_totalDeaths;
    }

    public void setSix_totalDeaths(Integer six_totalDeaths) {
        this.six_totalDeaths = six_totalDeaths;
    }

    public Integer getSix_newDeaths() {
        return this.six_newDeaths;
    }

    public void setSix_newDeaths(Integer six_newDeaths) {
        this.six_newDeaths = six_newDeaths;
    }

    public Integer getSix_total_tests() {
        return this.six_total_tests;
    }

    public void setSix_total_tests(Integer six_total_tests) {
        this.six_total_tests = six_total_tests;
    }

    public Integer getSix_new_tests() {
        return this.six_new_tests;
    }

    public void setSix_new_tests(Integer six_new_tests) {
        this.six_new_tests = six_new_tests;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public SixMonthsStatistics(){        
    }
}
