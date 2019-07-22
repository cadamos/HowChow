Feature: Searching Dishes

  Scenario: Search dishes with tags
    Given I am on the HowChow Home Page
    When I click in search box
    And select a dish tag
    Then I should be able to see a list of dishes
