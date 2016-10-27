Feature: perform search in the fund.nl
  Using quick search.

@OpenHomePage
Scenario Outline: Field error message validation
  When fill input parameters "<Place>","<Distance>","<MinPrice>","<MaxPrice>"
  Then I see text message saying"<Text>" located at "<Locator>"
  Examples:
    |Place        |Distance|MinPrice    |MaxPrice       |Text   |Locator|
    |Eindhoven    |1       |50000       |75000          |       |       |
