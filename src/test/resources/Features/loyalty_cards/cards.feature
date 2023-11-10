Feature: Super Smoothie Loyalty Card Program
  The more smoothies you buy, the more points you earn.

  Background:
    Given the following drink categories:
      | Drink              | Category | Points |
      | Apple and Kate     | Regular  | 15     |
      | Triple Berry Blend | Fancy    | 20     |
      | Early Gray         | Tea      | 10     |

  Scenario Outline: Earning points when purchasing smoothies
    Examples:
    Given Vanilson is a Morning Freshness member
    When  Vanilson purchases <Quantity> <Drink> drinks
    Then  he should earn <Points> points:
      | Quantity           | Drink | Points |
      | Apple and Kate     | 2     | 30     |
      | Triple Berry Blend | 1     | 20     |
      | Early Gray         | 3     | 30     |