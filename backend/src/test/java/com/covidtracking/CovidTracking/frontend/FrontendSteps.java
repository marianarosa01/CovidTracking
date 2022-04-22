package com.covidtracking.CovidTracking.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class FrontendSteps {
    
    private WebDriver driver;

    
    @Given("the url {string}")
    public void browseTo(String url) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1479, 837));
    }

    @When("When the customer want's to check today world data")
    public void checkTodaysData(){
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString("Today's World Data"));
    }


    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
