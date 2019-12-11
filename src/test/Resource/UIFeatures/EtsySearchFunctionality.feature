@TEC-106 @RegressionTest
Feature: Etsy Search Functionality
@TECTC-1011 @smokeTest
  Scenario Outline:Validate Etsy Search message
    Given Navigate Etsy Home page
    When  User searches for "<item>"
    Then Validate search message have word "<item>"
    Examples:
      | item   |
      | carpet |
      | 123    |

@TECTC-1012
  Scenario Outline:  Validate each department of Etsy has valid title
    Given Navigate Etsy Home page
    When User clicks on "<Department>"
    Then User validate title "<title>"
    Examples:
      | Department            | title                        |
      | Jewelry & Accessories | Jewelry & Accessories \| Etsy  |
      | Home & Living         | Home & Living \| Etsy        |
      | Wedding & Party       | Wedding & Party \| Etsy      |
      | Toys & Entertainment  | Toys & Entertainment \| Etsy |
@TESTTC-1013
Scenario: Validate to wireles phone Charger
  Given Navigate Etsy Home page
  Then User search "wireless phone charger"
  Then User click Free Shipping
  And User verify it is has  free shipping label
  @TECTC-1014 @smokeTest
  Scenario: Validating Over price functionality
    Given Navigate Etsy Home page
    When User searches for "carpet"
    And User click on Over Price checkbox
    Then User verifies all items prices are over that price

