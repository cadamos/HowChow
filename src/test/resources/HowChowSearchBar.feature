
Feature: HowChowSearchBar
  I want to use this template for my feature file

Background: 
	Given I am on HowChow's site
	
  Scenario Outline: Searching for a specific tag
    Given The search bar's values are loaded
    When I select the "<tag>" tag
    Then "<dish1>" and "<dish2>" should be loaded below
    
  Examples:
		| tag | dish1 | dish2 |
		| Chicken | Pad Thai | Chicken Alfredo |
		| Pasta | Ramen | Pad Thai |
    

