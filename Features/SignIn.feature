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



@SignIn
Feature: Verification of Sign In Functionality
  Appearances and Functionalities of various parts of Sign In page are tested

  @Appearance
  Scenario: To validate that the redirection to Sign In page with proper fields occurs after clicking on Sign In option
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And two textboxes for email and password should be visible and enabled
    And a Sign In button should be visible and clickable
    
  @Functional @Valid
  Scenario: To validate by providing valid values for email and password in the Sign In page
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And two textboxes for email and password should be visible and enabled
    And a Sign In button should be visible and clickable
    When I enter valid email as <"dipanwita.jash@gmail.com"> in Sign In page
    And I enter valid password as <"Dipa1234$"> in Sign In page
    And I click on Sign In button
    Then I wait
    When I click on the Sign In option
    When I enter valid email as <"dipanwita.jash@gmail.com"> in Sign In page
    And I enter valid password as <"Dipa1234$"> in Sign In page
    And I click on Sign In button
    
  @Functional @Invalid @Null
  Scenario: To validate by providing invalid and null values for email and password in the Sign In page
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And two textboxes for email and password should be visible and enabled
    And a Sign In button should be visible and clickable
    When I enter email as <"<email>"> in Sign In page
    And I enter password as <"<password>"> in Sign In page
    And I click on Sign In button
    Then I wait
    When I click on the Sign In option
    When I enter email as <"<email>"> in Sign In page
    And I enter password as <"<password>"> in Sign In page
    And I click on Sign In button
    Then I get an error message stating that email or password is incorrect
    
    Examples: 
      | email       | password  |
      | abc_def.com | abc       |
      |             |           |
      
  
