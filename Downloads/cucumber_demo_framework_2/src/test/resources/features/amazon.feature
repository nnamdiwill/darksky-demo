@regression @amazonlogin
Feature: Login feature

  Background:




#  @amazonlogin-1
#    Scenario: Verify Hover Function
#    Given I am on Amazon home page
#    When I hover over sign in account
#    Then I click on sign in button

  @AmazonLogin-test1
  Scenario: I should see password incorrect error message

    Given I go to Signin Page
    When I enter username nnamdiwill@gmail.com
    And  I enter pwrd in password box
    When I click on signin button
    Then I should get an error message

  @AmazonLogin-test2
  Scenario: I leave username blank

    Given I am on Signin Page
    When I don't enter username
    And I enter charliepw as my password
    Then I should receive enter email error message

  @AmazonLogin-test3
  Scenario: I click on Create an amazon account

    Given I click on create Amazon account
    When I put username as Kevin Code
    And I enter email as kcode@gmail.com
    And I click on next box
    Then I should get enter password error

  @AmazonLogin-test4
  Scenario: I leave email and PW blank

    Given I am going on Create account page
    When I type in Kevin code for name
    And I leave email and password blank and I click on next box
    Then I should get error messages

  @AmazonLogin-test5
  Scenario: I enter password but don't re-enter password

    Given I head to Create account Page
    When I put username for Kevin Code
    And I enter  the email as kcode@gmail.com
    And I enter password a abcef
    And I click on create box
    Then I should get an error message.

  @AmazonLogin-test6
  Scenario: Invalid email

    Given I'm still going to the create account page
    When I  still put username as Kevin Code
    And I enter email as kcode
    And I enter password a abcEfg@
    And I re-enter pw as abcEfg@
    And I do a click for create Amazon account
    Then I should receive error message for invalid email

  @AmazonLogin-test7
  Scenario: email verify

    Given I'm staying on Create account page
    When I set username as Kevin Code
    And I do email as kcode@gmail.com
    And I enter password a abcEfg@ again
    And I re-enter pw as abcEfg@ again
    And I click on create Amazon account for verification
    Then I should get verify email page

    @AmazonLogin-test8
    Scenario: Forgot Password

      Given I'm at the Sign in page after mouseover.
      When I send my email to kcode@gmail.com.
      And I click on Forgot your password.
      Then The password assistance page should come up.


      @AmazonLogin-test9
      Scenario: Look up Superman DVD
        Given I'm on the offical Homepage.
        When I type in Superman dvd.
        And Scroll down to Christopher Reeve Collection.
        And I click and at to cart.
        Then I should end up on sign in page.

