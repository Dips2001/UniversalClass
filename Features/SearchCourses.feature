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



@SearchCourses
Feature: Verification of Search Courses Functionality
  Appearances and Functionalities of various parts of Search Courses section are tested

  @Functional @Valid
  Scenario: To validate that results related to searched course are given when search criteria matches with any available courses
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    And a search box should be visible and enabled
    And a search icon should be visible and clickable
    When I enter search string as <"Business">
    And I click on search icon
    Then I get course results related to searched string
    
  @Functional @Invalid @Null
  Scenario: To validate that suggestions are given if search string does not match any records or search string is empty and search icon is clicked
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    And a search box should be visible and enabled
    And a search icon should be visible and clickable
    When I enter search string as <"<search_string>">
    And I click on search icon
    Then I get suggestions of available courses
    
    Examples: 
      | search_string |
      | Flask         |
      |               |
      
  