Feature: Search for an item and click on an item on Amazon
  
  Background:
  Given User Navigates to Amazon HomePage without being logging in

  Scenario: Searching for item and navigating to item Product Details Page
    Given User Searches For <item>
    And User is navigated to <item> search results page, selects first item on Search Page
    Then Product details Page Corresponding with selected entry is displayed

Examples:
    |  item      |
    |    1:64 Diecast |
    |    Soap    |
    