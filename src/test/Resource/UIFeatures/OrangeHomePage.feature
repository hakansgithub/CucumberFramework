@ProjectOrange
Feature: HR Management Application
  Scenario: Login as an Admin and change password
    Given Navigate Orange Page
   And User login in with valid credentials username "Admin" password"admin123"
    Then Change password for Fiano Grace
    And  Verify it is changed  by signing in again


    @ProjectOrange1
    Scenario: Login to application and go to Leave section and verify Linda Anderson’s number leave days
      Given Navigate Orange Page
      And User login in with valid credentials username "Admin" password"admin123"
      Then User click Leave section and Choose Linda Anderson’s number leave days
      And User verify Linda Anderson’s number leave days properly calculated by going to details of leave and counting the day

  @ProjectOrange2
  Scenario:Login and go to job Title section
    Given Navigate Orange Page
    And User login in with valid credentials username "Admin" password"admin123"
    And User click Job title and add IT SDET job
    Then User job Title section and added IT SDET job and verify it is added.