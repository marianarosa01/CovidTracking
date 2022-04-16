package com.covidtracking.CovidTracking.models;


import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place  {
    @Id
    private String id;
    private String country;
    private String continent;
    private Long population;

  
    private Statistics stats;

    public String getCountryId() {
        return this.id;
    }

    public void setCountryId(String id) {
        this.id = id;
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

    public Long getPopulation() {
        return this.population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Place() {

    }


    public Place(String Id, String country, String continent, Long population) {
        this.id = Id;
        this.country = country;
        this.continent = continent;
        this.population = population;
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getCountryId() + "'" +
            ", country='" + getCountry() + "'" +
            ", continent='" + getContinent() + "'" +
            ", population='" + getPopulation() + "'" +
            "}";
    }


    

}
