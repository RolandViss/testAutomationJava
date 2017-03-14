Feature: Step definition
	As a test engineer I want to learn how to write scenarios with different steps

  Scenario: Exact match
	When I am on the home page
	Then some text should be seen on homepage
    
  Scenario: Capture integers and strings
	When I am on the "Locators" page
    Then I should see "Base page" header text
    And I should see sample text 1
    And I should see sample text 2
    
  Scenario: Use non-capturing groups
	When I am on the "Locators" page
    Then I should see "unbelievable" text
    And I can see "amazing" text
    And I can see "dummy" text
  
  Scenario: Use Data Tables 1 
	Given I am on the "Actions" page
	When I select options:
		| Option 2 |
		| Option 3 |
	Then I see options checked:
		| text 	   | is checked |
		| Option 1 | unchecked 	|
		| Option 2 | checked  	|
		| Option 3 | checked 	|

  Scenario: Use Data Tables 2
	When I am on the "Actions" page
	Then I see default values:
	 	| text box 	 | This is a text box    |
	 	| number box | 5 				     |
	 	| text area  | This is a text area 	 |
	 	| select 	 | Choose your option 	 |
	 	| url 		 | http://www.google.com |
	 	