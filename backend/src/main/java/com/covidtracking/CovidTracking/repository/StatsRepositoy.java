package com.covidtracking.CovidTracking.repository;

import com.covidtracking.CovidTracking.entities.Statistics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepositoy extends JpaRepository<Statistics,Integer>  {

    Statistics findByName(String name);

}

