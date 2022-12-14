Feature: Get Post Lists
  #sukses
  @gorest
  Scenario Outline: Get list posts with valid page parameter
    Given Get list posts with valid parameter page <page>
    When Send get list posts request
    Then Should return 200 OK
    And Validate get list posts json schema
    Examples:
      |page|
      |1   |
      |2   |

    #bug
  @gorest
  Scenario Outline: Get list posts with invalid parameter page with character & special character
    Given Get list posts with invalid parameter page "<page>"
    When Send get list posts request
    Then Should return 404 not found
    Examples:
      |page   |
      |^*&$#  |
      |abcd   |