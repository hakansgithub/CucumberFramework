@TEC-104
Feature: Validating My Address Functionality
  Scenario: Go to your account and update your address and verify it is updated (Datatable)
    Given Navigate to login page
    Then User to sign in button
    And User signs in with valid credentials email "Nancykup@gmail.com" and password "0123123123"
    Then Click on My Addresses link and press update button
    Then User edits his Address information
      | Adress           | City  | State    | Zip| Country       |
      | 1101 N Cicero Ave | Niles | New York | 60644| United States |
    And Verify the Address is updated

