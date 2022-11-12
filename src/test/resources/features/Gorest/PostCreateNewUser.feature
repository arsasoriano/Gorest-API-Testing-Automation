Feature: Post Create New User
  @gorest
  Scenario: Post create user using valid body json
    Given Post create new user with valid body json
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 201 created
    And Validate post create new user valid value json schema

#  @gorest
#  Scenario: Post create user using valid body json without authentication
#    Given Post create new user using valid body json without authentication
#    When Send post create new user request
#    Then Response body should be 401 unauthorized
#    And Validate post create new user unauthorized error message json schema

  @gorest
  Scenario: Post create user with empty name
    Given Post create new user without input name
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    And Validate post create new user unprocessable json schema

  @gorest
  Scenario: Post create user with empty email
    Given Post create new user without input email
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    And Validate post create new user unprocessable json schema

  @gorest
  Scenario: Post create user with empty gender
    Given Post create new user without input gender
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    And Validate post create new user unprocessable json schema

  @gorest
  Scenario: Post create user with empty status
    Given Post create new user without input status
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    And Validate post create new user unprocessable json schema