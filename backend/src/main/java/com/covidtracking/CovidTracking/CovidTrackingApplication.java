package com.covidtracking.CovidTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CovidTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTrackingApplication.class, args);
	}

}
