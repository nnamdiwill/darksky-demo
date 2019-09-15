@DarkSkyAPITests @regressionAPI
Feature: Darsky API Verification


  Background:

  @DarkSkyAPI-1
  Scenario: Verify Api button works
    Given I am on Darksky HomePage.
    When I click on DarkSkyAPI.
    And I sign up in Darksky api.
    Then I go to the email I entered and verified my Darksky API account.




