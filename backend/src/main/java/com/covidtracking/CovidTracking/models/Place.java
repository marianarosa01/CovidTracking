package com.covidtracking.CovidTracking.models;


import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place  {
    @Id
    private String iso;
    private String country;
    private String continent;
    private Integer population;


    public String getIso() {
        return this.iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
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

    public Integer getPopulation() {
        return this.population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Place() {

    }


    public Place(String country, String iso, String continent, Integer population) {
        this.country = country;
        this.continent = continent;
        this.population = population;
        this.iso = iso;
    }

    @Override
    public String toString() {
        return "{" +
            " Country='" + getCountry() + "'" +
            ", continent='" + getContinent() + "'" +
            ", population='" + getPopulation() + "'" +
            ", iso='" + getIso() + "'" +

            "}";
    }


    

}
