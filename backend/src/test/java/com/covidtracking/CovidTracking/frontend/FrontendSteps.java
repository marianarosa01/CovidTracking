package com.covidtracking.CovidTracking.frontend;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class FrontendSteps {
    
    private WebDriver driver;

    
    @When("I'm accessing {string}")
    public void browseTo(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1479, 837));
    }



    @When ("the user clicks on {string} button")
    public void checkButtonClick(String button){
        switch (button) {
            case "search":
              driver.findElement(By.id("searchButton")).click();
              break;
            case "Specific Country":
                driver.findElement(By.id("specificCountry")).click();
                break;

            case "All Countries":
                driver.findElement(By.linkText("All countries")).click();
                break;
          }
    }

    @Then("the user should see the following message \"Today's World Data\" with the informations")
    public void checkTodayWorldData(){
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString("Today World's COVID-19"));
    }

    @And ("the user searches for {string} on the search bar")
    public void search(String country){
        driver.findElement(By.id("searchform")).click();
        driver.findElement(By.id("country")).sendKeys(country);

    }

    @Then("{string} statistics are presented in a table") 
    public void getResults(String country) throws InterruptedException{
        Thread.sleep(2000); // wait for the data
        assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), containsString(country));
    }
    
 
/* not working
   @Then("the user should see an alert saying that the country does not exist")
    public void alert(){
       
        Alert alert = driver.switchTo().alert(); 
        String alertMessage= alert.getText(); 
        alert.accept();
        System.out.println("Alert msg is : "+alertMessage);
        assertThat(alertMessage, containsString("Try another one"));
    } 
   
 */
    @After()
    public void closeBrowser() {
        driver.quit();
    }

   

}
