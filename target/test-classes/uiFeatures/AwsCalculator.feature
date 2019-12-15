# new feature
# Tags: optional

Feature: Testing AWS Calculator

  @TECTC-110 @ui @smokeTest
  Scenario: Testing calculation of prices EC2 instances
    Given User navigates to AWS Calculator Homepage
    When User adds 2 EC2 instances
    And User adds 2 EC2 Dedicated Hosts
    Then Total estimated cost has to match with prices on "testData" "Sheet2" excel file
