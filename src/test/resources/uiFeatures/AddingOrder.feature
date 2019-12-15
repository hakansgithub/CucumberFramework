@TEC-102
Feature: Adding Order

  Scenario: Verify create order functionality
    Given Navigate to login page
    Then User logs in with valid credentials username "Tester" password "test"
    And User clicks on Order
    Then User creates new Order
      | Product Name | Quantity | Customer Name | Street     | City    | State | Zip   | Card Number | Expiration Date |
      | ScreenSaver  | 2        | Techtorial    | 123 N Tech | Chicago | IL    | 60601 | 123456789   | 12/21           |
    Then User verifies Order "is" created

  Scenario: Verify create order functionality with invalid data
    Given Navigate to login page
    Then User logs in with valid credentials username "Tester" password "test"
    And User clicks on Order
    Then User creates new Order
      | Product Name | Quantity | Customer Name | Street     | City    | State | Zip     | Card Number | Expiration Date |
      | ScreenSaver  | 2        | Techtorial    | 123 N Tech | Chicago | IL    | zipCode | 123456789   | 12/21           |
    Then User verifies Order "is not" created