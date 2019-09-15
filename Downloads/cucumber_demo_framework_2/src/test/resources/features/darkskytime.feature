@DarkSkyTests @regression
Feature: Verify Temp Timeline


  Background:


  @DarkSkyTest-1
  Scenario: Verify the timeline is displayed in 2 hour increments
    Given I am on darksky home page and create object for starting point.
    Then I verify the timelin is diplayed in 2 hour increments.

  @DarkSkyTest-2
  Scenario: Verify individual day temp timeline
    Given I am on darksky home page and will create an object.
    When I expand todays timeline.
    Then I verify lowest and highest temp is displayed correctly.


@DarkSkyTest-3
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Given I am on Darksky Home Page.
    Then I verify current temp is not greater or less then temps from daily timeline.

