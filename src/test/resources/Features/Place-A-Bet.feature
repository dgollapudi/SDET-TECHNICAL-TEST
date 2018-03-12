@placeabet
Feature: As a WH Customer
  I want the ability to place a bet on a English Premier League event

  @desktop
  Scenario Outline: Place a bet on a English Premier League event
    Given I am navigated to desktop williamhill sportsbook page on <platform>
    And I am logged in to my sportsbook account
    And  I am navigated to a Premiership football event page
    When I selected football event and enter <Bet Stake> for the home team to 'Win'
    Then I asserted the odds and returns offered for above <Bet Stake>
    And I placed a bet
    Then I closed browser

    Examples:
      | platform |  Bet Stake |
      | desktop  |  0.05      |



  @mobile
  Scenario Outline: Place a bet on a English Premier League event
    Given I am navigated to mobile williamhill sportsbook page on <platform>
    And I am logged in to my mobile sportsbook account
    And  I am navigated to a Premiership football event page
#    When I selected football event and enter <Bet Stake> for the home team to 'Win'
#    Then I asserted the odds and returns offered for above <Bet Stake>
#    And I placed a bet
#    Then I closed browser

    Examples:
      | platform |  Bet Stake |
      | mobile  |  0.05      |


