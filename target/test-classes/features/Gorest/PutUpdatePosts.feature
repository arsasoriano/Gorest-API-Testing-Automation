Feature: Update Posts Feature
  @gorest
  Scenario Outline: Put update posts with valid body json and valid id
    Given put update posts with valid body json and valid id <id>
    When send put update posts request with authentication
    Then response code should be 200 ok
    And response body should contain title "Testing API Gorest Update" and body "QA Team 2 Testing API on Gorest Update"
    Examples:
      | id   |
      | 2404 |
      | 2405 |

  @gorest
  Scenario Outline: Put update posts with valid body json and invalid id
    Given put update posts with valid body json and invalid id "<id>"
    When send put update posts request with authentication
    Then response code should be 404 not found
    Examples:
      | id |
      | aa |
      | $@ |

  @gorest
  Scenario Outline: Put update posts without authentication
    Given put update posts with valid body json and valid id <id>
    When send put update posts request without authentication
    Then response code should be 401 Unauthorized
    Examples:
      | id   |
      | 2404 |
      | 2405 |

  @gorest
  Scenario Outline: Put update posts with invalid title
    Given put update posts with invalid title and valid id <id>
    When send put update posts request with authentication
    Then response code should be 422 Unprocessable Entity
    Examples:
      | id   |
      | 2404 |
      | 2405 |

  @gorest
  Scenario Outline: Put update posts with invalid body
    Given put update posts with invalid body and valid id <id>
    When send put update posts request with authentication
    Then response code should be 422 Unprocessable Entity
    Examples:
      | id   |
      | 2404 |
      | 2405 |

  @gorest
  Scenario Outline: Put update posts with invalid body json
    Given put update posts with invalid body json and valid <id>
    When send put update posts request with authentication
    Then response code should be 422 Unprocessable Entity
    Examples:
      | id   |
      | 2404 |
      | 2405 |