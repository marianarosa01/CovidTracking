package com.covidtracking.CovidTracking.entities;


import java.lang.annotation.Inherited;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Place  {
    @Id
    private Long countryId;
    private String country;
    private String continent;
    private int population;

    public Long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Place() {

    }


    public Place(Long countryId, String country, String continent) {
        this.countryId = countryId;
        this.country = country;
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "{" +
            " countryId='" + getCountryId() + "'" +
            ", country='" + getCountry() + "'" +
            ", continent='" + getContinent() + "'" +
            ", population='" + getPopulation() + "'" +
            "}";
    }

    

}
