Feature: Search Clarivate Feature
  Verify if user is able to Search for Clarivate in Google site

  Scenario: Login as a authenticated user
    Given launch googlepage
    When Search given String "Clarivate Analytics"
    Then Validate search Result