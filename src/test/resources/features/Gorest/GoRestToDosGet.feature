Feature: GoRest Feature test
@ToDos
  Scenario: Get to do is
  Given Set path paramater page
  And Click send button
  Then API should return response 200 OK
@ToDos
Scenario: Get to do is
When Set path to invalid parameter
  And Click send button invalid
  Then API should return response 404 Not Found
@ToDos
  Scenario Outline: Get to do is
  Given Set path to param id <id>
  And Click send button for id
  Then API should return response 200 OK
  Examples:
    | id   |
    | 1    |
    | 2400 |
    | 100000     |

  @ToDos
  Scenario Outline: Get to do is
    When Set path to param ID <ID>
    And Click send button for ID
    Then API should return response 200 OK
Examples:
  | ID     |
  | 1      |
  | 2400   |
  | 100000 |
@ToDos
Scenario Outline: Get to do is
  When Set path to param ID <ID>
  And Click send button for ID +key&go
  Then API should return response 200 OK
  Examples:
    | ID     |
    | 100000 |
  @ToDos
  Scenario Outline: Get to do is
    When Set path to param ID <ID>
    And Click send button for ID +KEY&GO
    Then API should return response 200 OK
    Examples:
      | ID     |
      | 100000 |

