@regressionTest
Feature: tags

  @smokeTest @sanityTest
  Scenario: The home page
	When I am on the Home page
	And I click "send"
	And I click "Ludzu "
    Then I should see "This is a home page" header text
    
  @sanityTest
  Scenario: The Locators page
	When I am on the "Locators" page
    Then I should see "Base page" header text
    
    
  Scenario: The Page with Links page
	When I am on the "Page with Links" page
    Then I should see "Lorem ipsum" header text
    