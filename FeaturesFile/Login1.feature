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
Feature: Login
 
  @sanity
 Scenario: Scucessful Login with Valid Credentails
	Given User Launch Chrome Browser
	When User Opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser

  @Regression
  Scenario Outline: Scucessful Login with Valid Credentails
	Given User Launch Chrome Browser
	When User Opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<UserName>" and Password as "<PassWord>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser


   Examples:
 |UserName            |PassWord|
 |Admin@gmail.com     |admin12 |
 |admin@yourstore.com |admin   |
 |Admin@gmail.com     |admin12 |
