Feature: perform search in the fund.nl
  Using koop search.


Scenario: koop search
  When I enter data in search fields
    |Fields        |values          |
    |Place         |Eindhoven       |
    |Distance      |1               |
    |MinPrice      |50000           |
    |Maxprice      |75000           |
  Then I see the search results of the search
