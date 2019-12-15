@TEC-103
Feature: Etsy Search Functionality

  Scenario Outline: Validate Etsy search message
    Given Navigate Etsy Homepage
    When User searches for "<item>"
    Then validate search message have the word "<item>"
    Examples:
      | item   |
      | carpet |
      | 123    |

  Scenario Outline: Validate each department of Etsy has a valid title
    Given Navigate Etsy Homepage
    When User clicks on "<department>"
    Then User validate the title "<title>"
    Examples:
      | department            | title                         |
      | Jewelry & Accessories | Jewelry & Accessories \| Etsy |
      | Clothing & Shoes      | Clothing & Shoes \| Etsy      |
      | Home & Living         | Home & Living \| Etsy         |
      | Wedding & Party       | Wedding & Party \| Etsy       |
      | Toys & Entertainment  | Toys & Entertainment \| Etsy  |

  @TECTC-1013
  Scenario: Validating free shipping label on result items
    Given Navigate Etsy Homepage
    When User searches for "Wireless Phone Charger"
    And User clicks on Free Shipping checkbox
    Then Verify all results that have "FREE shipping" label

