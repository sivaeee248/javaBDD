Feature: Search Clarivate Feature
  Verify if user is able to Search for Clarivate in Google site

  Scenario: Automation task 1 - Validate Google Search for Clarivate Analytics
    Given Open Browser
    When Navigate to Google
    And Search given String "Clarivate Analytics"
    Then Validate search Result "https://clarivate.com/"