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



@ForgotPassword
Feature: Verification of Forgot Password Functionality
  Appearances and Functionalities of various parts of Forgot Password page are tested

  @Appearance @fp
  Scenario: To validate that the redirection to Forgot Password page with proper fields occurs after clicking on Forgot your password link
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then I wait
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then Forgot Password page should be displayed
    And a textbox for email should be visible and enabled
    And a Recover Password button should be visible and clickable
    
    
  @Functional @Valid
  Scenario: To validate by providing valid values for email and password in the Forgot Password page
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then I wait
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then Forgot Password page should be displayed
    And a textbox for email should be visible and enabled
    And a Recover Password button should be visible and clickable
    When I enter valid email in Forgot Password page
    And I click on Recover Password button
    Then I get a Password Reset Request mail
    
    
  @Functional @Invalid
  Scenario: To validate by providing invalid and null values for email and password in the Sign In page
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then I wait
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then Forgot Password page should be displayed
    And a textbox for email should be visible and enabled
    And a Recover Password button should be visible and clickable
    When I enter invalid email in Forgot Password page
    And I click on Recover Password button
    Then I get an error message stating that email was not found
    
  @Functional @Null
  Scenario: To validate by providing invalid and null values for email and password in the Forgot Password page
    Given UniversalClass website is ready
    When I launch URL in chrome browser
    Then Home page of UniversalClasses website should open
    When I click on the Hamburger icon
    Then Sign In option should be visible
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then I wait
    When I click on the Sign In option
    Then Sign In page should be displayed
    And a Forgot Password link should be visible
    When I click on the Forgot your password link
    Then Forgot Password page should be displayed
    And a textbox for email should be visible and enabled
    And a Recover Password button should be visible and clickable
    When I enter null email in Forgot Password page
    And I click on Recover Password button
    Then I get an error message stating that email was not found
    
      
