Feature: Delete Posts Feature
  @gorest
  Scenario Outline: Delete posts with valid id
    Given delete posts with valid id <id>
    When send delete posts request with authentication
    Then response code should be 204 no content
    Examples:
      | id |
      | 1  |
      | 2  |

  @gorest
  Scenario Outline: Delete posts with invalid id
    Given delete posts with invalid id "<id>"
    When send delete posts request with authentication
    Then response code should be 404 not found
    Examples:
      | id |
      | aa |
      | @# |

  @gorest
  Scenario Outline: Delete posts without authentication
    Given delete posts with valid id <id>
    When send delete posts request without authentication
    Then response code should be 401 Unauthorized
    Examples:
      | id   |
      | 1772 |