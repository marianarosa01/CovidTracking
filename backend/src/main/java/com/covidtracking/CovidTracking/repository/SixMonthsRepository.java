package com.covidtracking.CovidTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidtracking.CovidTracking.entities.SixMonthsStatistics;


public interface SixMonthsRepository extends JpaRepository<SixMonthsStatistics,Integer>  {

    SixMonthsStatistics findByName(String name);

}




   
