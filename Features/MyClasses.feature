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



@MyClasses
Feature: Verification of My Classes Functionality
  Appearances and Functionalities of various parts of My Classes section are tested

  @Functional @Unregistered
  Scenario: To validate that redirection occurs to the Sign In page if the customer is not registered
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    And I should see My Classes button
    When I click on My Classes button
    Then Sign In page should be displayed
    
  @Functional @Registered
  Scenario: To validate that the joined courses is displayed if the customer is a member of the Universal Class
  	Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    When I enter valid email as <"dipanwita.jash@gmail.com"> in Sign In page
    And I enter valid password as <"Dipa1234$"> in Sign In page
    And I click on Sign In button
    Then I wait
    When I click on the Sign In option
    When I enter valid email as <"dipanwita.jash@gmail.com"> in Sign In page
    And I enter valid password as <"Dipa1234$"> in Sign In page
    And I click on Sign In button
    Then I get logged in to our respective profiles
    And joined courses should be displayed
