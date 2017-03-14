Feature: Browsing around

  Background:
	Given I am on the "Page with Links" page

  Scenario Outline: Check title of acticle
	When I click "More" on <article>
	Then I should see "<Article name>" header text
  Examples:
   | article 	| Article name   |
   | 1			| Lorem ipsum 1! |
   | 2			| Lorem ipsum 1! |
   | 3			| Lorem ipsum 3! |
   | 4			| Lorem ipsum 4! |
   | 5			| Lorem ipsum 5! |

  Scenario Outline: Check that "Back link works"
	When I click "More" on <article>
	And I click "Back" on article page
	Then I am taken back to "Page with Links"
  Examples:
   | article 	|
   | 1			|
   | 2			|
   | 3			|
   | 4			|
   | 5			|
 