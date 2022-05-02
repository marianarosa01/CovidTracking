package com.covidtracking.CovidTracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlRoutingController {

 

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public static String welcome() {
        return "index";
    }

    @RequestMapping(value = "/countrydata", method = RequestMethod.GET)
    public static String countrysearch() {
        return "countrydata";
    }

    @RequestMapping(value = "/cache", method = RequestMethod.GET)
    public static String cacheStat() {
        return "cache";
    }
}
