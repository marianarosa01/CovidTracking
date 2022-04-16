package com.covidtracking.CovidTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.covidtracking.CovidTracking.*"})
public class CovidTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTrackingApplication.class, args);
	}

}
