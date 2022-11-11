Feature: Create posts feature
  @gorest
  Scenario: Create posts with valid body json
    Given post create posts with valid body json
    When send post create posts request with authentication
    Then response code should be 201 created
    And response body should contain user_id 4933, title "Testing API Gorest" and body "QA Team 2 Testing API on Gorest"

  @gorest
  Scenario: Create posts without authentication
    Given post create posts with valid body json
    When send post create posts request without authentication
    Then response code should be 401 Unauthorized

  @gorest
  Scenario: Create posts with invalid user_id
    Given post create posts with invalid user_id
    When send post create posts request with authentication
    Then response code should be 422 Unprocessable Entity

  @gorest
  Scenario: Create posts with invalid title
    Given post create posts with invalid title
    When send post create posts request with authentication
    Then response code should be 422 Unprocessable Entity

  @gorest
  Scenario: Create posts with invalid body
    Given post create posts with invalid body
    When send post create posts request with authentication
    Then response code should be 422 Unprocessable Entity

  @gorest
  Scenario: Create posts with invalid body json
    Given post create posts with invalid body json
    When send post create posts request with authentication
    Then response code should be 422 Unprocessable Entity