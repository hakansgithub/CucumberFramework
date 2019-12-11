@TEC-113
  Feature: Find discounted dress
    Scenario: Find discounted dresses and verify it is discounted
      Given Navigate to web site
      Then User click Dress Link
      And User get old price and discount price
      And User verify price
