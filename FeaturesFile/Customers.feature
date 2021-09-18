Feature: Customers

  Background: Below are the common steps for each scenario
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Menu Item

  @sanity
  Scenario: Add new Customer
    And Click on Add new button
    Then User can view Add new Customer page
    When User enter Customer info
    And Click on Save Button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

  @regression
  Scenario: Search Customer by using EmailID
    And Enter Customer Email
    Then Click on search button
    Then User should find the customer email in the search tble
    And close browser

  @regression
  Scenario: Search Customer by Name
    And Enter Customer Firstname
    And Enter Customer Lastname
    Then Click on search button
    Then User should find the Name in the search table
    And close browser
