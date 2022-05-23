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


@CourseCatalog
Feature: Verification of Course Catalog Functionality
  Appearances and Functionalities of various parts of Course Catalog section are tested

  @Functional
  Scenario: To validate that results related to searched course are given when search criteria matches with any available courses
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    And I should see Course Catalog button
    When I click on Course Catalog button
    Then I get list of available courses
