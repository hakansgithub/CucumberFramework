@TEC-102 @ui @smokeTest @regressionTest
Feature: Adding Order

  Scenario: Verify create order functionality
    Given Nagivate to login page
    Then  User logs in with valid credentials username "Tester" password "test"
    And User clicks on Order
    Then User creates new order
      | Product Name | Quantity | Customer Name | Street    | City    | State | Zip   | Card Nr    | Expire Date |
      | ScreenSaver  | 2        | Techtorial    | 123 N tec | Chicago | IL    | 60000 | 1234453556 | 12/21       |

    Then User verifies Order "is" created

    Scenario: Verify create order functionality with invalid data
      Given Nagivate to login page
Then User logs in with valid credentials username "Tester" password "test"
      And User clicks on Order
      Then User creates new order
        | Product Name | Quantity | Customer Name | Street    | City    | State | Zip   | Card Nr    | Expire Date |
        | ScreenSaver  | 2        | Techtorial    | 123 N tec | Chicago | IL    | 60000 | 1234453556 | 12/21       |
      Then User verifies Order "is NOT" created
      @TECTC-1018
      Scenario Outline: Verify delete functionality
        Given Nagivate to login page
        Then  User logs in with valid credentials username "Tester" password "test"
        And User deletes "<Name>" from table
        And User validate that "<Name>" is deleted
        Examples:
          |Name|
          |Mark Smith|
          |Samuel Clemens|
           | Paul Brown   |




