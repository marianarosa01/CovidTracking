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

    @When("the customer want's to check today world data")
    public void checkTodaysData(){
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString("Today's World Data"));
    }

    @And ("he/she clicks in {string} button")
    public void checkButtonClick(String button){
        switch (button) {
            case "search":
              driver.findElement(By.id("searchButton")).click();
              break;
            case "Specific Country":
                driver.findElement(By.cssSelector(".nav-item:nth-child(6) > .nav-link")).click();
                break;

            case "All Countries":
                driver.findElement(By.linkText("All countries")).click();
                break;
          }
    }

    @Then("he/she should see the following message \"Today's World Data\" with the informations")
    public void checkTodayWorldData(){
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString("Today's World Data"));
    }

    @And ("he/she searches for {string} on the search bar")
    public void search(String country){
        driver.findElement(By.id("country")).sendKeys(country);
    }

    @Then("{string} statistics are presented in a table") 
    public void getResults(String country){
        assertThat(driver.findElement(By.cssSelector(".d-sm-flex:nth-child(1)")).getText(), containsString(country));
    }
    
    @Then ("he/she should see an alert saying that the country doens't exist")
    public void alert(String a){
        assertThat(driver.findElement(By.cssSelector(".d-sm-flex:nth-child(1)")).getText(), containsString("This country does not exist!"));
    }
  

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
