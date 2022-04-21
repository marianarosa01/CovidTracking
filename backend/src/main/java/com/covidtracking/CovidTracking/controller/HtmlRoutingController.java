package com.covidtracking.CovidTracking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlRoutingController {
    @RequestMapping(value="/index")
    public static String welcome() {
        return "index";
    }

    @RequestMapping(value="/countrydata")
    public static String countrysearch(){return "countrydata";}

    @RequestMapping(value="/sixmonthsstatistics")
    public static String airQualitySearch() {
        return "airqualitysearch";
    }

    @RequestMapping(value="/allcountries")
    public static String weatherSearch() {
        return "weathersearch";
    }
}
