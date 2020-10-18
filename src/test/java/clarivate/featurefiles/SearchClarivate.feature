Feature: Search Clarivate Feature
  Verify if user is able to Search for Clarivate in Google site

  Scenario: Automation task 1 - Validate Google Search for Clarivate Analytics
  	Given user Opens Browser
	When user is on "https://www.google.com/" homepage
	Then user enters "Clarivate Analytics" in searchbox
	Then The first search result should be "https://clarivate.com/"
	And Close browser
    