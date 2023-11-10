Feature: Super smoothie Loyalty Card Program
  Scenario Outline: Earning loyalty card points
    Given Vanilson is a Freshness member
    When Vanilson purchases 1 <Sample Drink>
    Then I should earn <Points Earned> points

    Examples:
      | Drink Category    | Sample Drink    | Points Earned |  |
      | Regular smoothies | Banana smoothie | 15            |  |
