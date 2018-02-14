Feature: Ability to place a bet on a English Premier League event


Scenario Outline: As a WH Customer I want to place a bet on a English Premier League event using Desktop

Given I open WilliamHill football Competitions betting page from "desktop"
And I go to English Premier League events
And I log in as user with login "WHITA_jiwanski" and password "GranadaWH07"
When I place a bet "<value>" for home team to 'Win'
Then I will see returns based on bet and odds

Examples: Valid monetary values
| value |
| 0.05 |
| 100 |


Scenario Outline: As a WH Customer I want to place a bet on a English Premier League event using Mobile

Given I open WilliamHill football Competitions betting page from "mobile"
And I go to English Premier League events
And I log in as user with login "WHITA_jiwanski" and password "GranadaWH07"
When I place a bet "<value>" for home team to 'Win'
Then I will see returns based on bet and odds

Examples: Valid monetary values
| value |
| 0.05 |
| 100 |