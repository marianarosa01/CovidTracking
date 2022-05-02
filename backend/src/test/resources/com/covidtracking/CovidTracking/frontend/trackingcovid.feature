Feature: Tracking

  Scenario: Search for all world covid statistics
     When I'm accessing "http://localhost:8080/"
        And the user clicks on "All Countries" button
     Then the user should see the following message "Today's World Data" with the informations

  Scenario: See Croatia statistics
        When I'm accessing "http://localhost:8080/countrydata"
            And the user clicks on "Specific Country" button
            And the user searches for "Croatia" on the search bar
            And the user clicks on "search" button
        Then "Croatia" statistics are presented in a table

  Scenario: User searches for a nonexistent country
        When I'm accessing "http://localhost:8080/countrydata"
            And the user searches for "Azores" on the search bar
            And the user clicks on "search" button

