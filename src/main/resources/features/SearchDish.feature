Feature: Searching of Wikipedia

	Scenario: Search dishes with tags
	
		Given I am on the HowChow Home Page
		When I type a tag name in search box
		And  I should click search button
		Then I should be able to see a list of dishes