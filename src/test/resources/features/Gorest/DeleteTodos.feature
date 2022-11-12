Feature: Delete todos
  @gorest
  Scenario Outline: Delete todo with valid id
    Given Delete todo using valid id <id>
    When Send delete todo request
    Then Status code should be 204 No Content
    Examples:
    | id    |
    | 1910  |
  @gorest
  Scenario Outline: Delete todo with invalid id
    Given Delete todo using invalid id <id>
    When Send delete todo request
    Then Should return 404 not found
    Examples:
    | id  |
    | 9000|
  @gorest
  Scenario Outline: Delete todo with valid id without token
    Given Delete todo using valid id <id>
    When Send delete todo request without token
    Then Response body should be 401 unauthorized
    Examples:
    | id  |
    | 1907|