Feature: Put Update Comment
  @gorest
  Scenario Outline: Put update comment with valid id
    Given Put update comment on body comment using valid id <id> and authenticated
    #And Set token authentication
    When Send put update comment request
    Then Response body code should be 200 OK
    Examples:
    | id  |
    | 1769|
  @gorest
  Scenario Outline: Put update comment with invalid id and authenticated
    Given Put update comment on body comment using invalid id <id>
    #And Set token authentication
    When Send put update comment request
    Then Should return 404 not found
    Examples:
    | id  |
    | 5000|
  @gorest
  Scenario Outline: Put update comment with valid id without authentication
    Given Put update comment on body comment using valid id <id>
    #And Set token authentication
    When Send put update comment request but not yet authenticated
    Then Response body should be 401 unauthorized
    Examples:
    | id  |
    | 1769|
  @gorest
  Scenario Outline: Put update comment with empty email input on body json and authenticated
    Given Put update comment with id <id> empty email input on body json
    #And Set token authentication
    When Send put update comment request
    Then Response body code should be 422 Unprocessable Entity
    Examples:
    | id  |
    | 1769|
  @gorest
  Scenario Outline: Put update comment with empty name input on body json and authenticated
    Given Put update comment with id <id> empty name input on body json
    When Send put update comment request
    Then Response body code should be 422 Unprocessable Entity
    Examples:
    | id  |
    | 1769|
  @gorest
  Scenario Outline: Put update comment with empty body comment on body json and authenticated
    Given Put update comment with id <id> empty body comment input on body json
    When Send put update comment request
    Then Response body code should be 422 Unprocessable Entity
    Examples:
    | id  |
    | 1769|
  @gorest
  Scenario Outline: Put update comment with empty input in body json on name and email and authenticated
    Given Put update comment with id <id> empty name and email
    When Send put update comment request
    Then Response body code should be 422 Unprocessable Entity
    Examples:
    | id  |
    | 1769|
  @gorest
  Scenario Outline: Put update commment with empty input in body json on name email and body comment and authenticated
    Given Put update comment with id <id> empty name email and body comment
    When Send put update comment request
    Then Response body code should be 422 Unprocessable Entity
    Examples:
    | id  |
    | 1769|