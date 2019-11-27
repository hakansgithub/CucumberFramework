 @TEC-101 @RegressionTest @ui
Feature: Verify Login fuctionality
  Background: Common first steps
    Given Nagivate to login page
  @smokeTest
  Scenario: Verify with valid credentials
    Then  User logs in with valid credentials username "Tester" password "test"
     And   Verify user is in Homepage

    Scenario: Verify with invalid credentials
      Then  User logs in with invalid credentials username "Testers" password "test"
      And   Verify user gets error message"Invalid Login or Password."





