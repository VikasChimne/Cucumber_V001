#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Customers
  

  @sanity
 Background: Below are the common steps for each Scenario
  Given User Launch Chrome Browser
	When User Opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers Menu Item
	
Scenario: Add new Customner
	And Click on Add new button
	Then User can view Add new Customer page
	When User enter Customer info
	And Click on Save Button
	Then User can view confirmaion message "The new customer has been added successfully."
	And close browser

Scenario: Search Customer by using EmailID
	And Enter Customer Email
	Then Click on search button
	Then User should find the customer email in the search tble
	And close browser
	
@CustomerSearchByName
Scenario: Search Customer by Name
	And Enter Customer Firstname
	And Enter Customer Lastname
	Then Click on search button
	Then User should find the Name in the search table
	And close browser