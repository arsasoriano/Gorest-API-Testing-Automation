Feature: Post Create New User
  #gagal
  @gorest
  Scenario: Post create user using valid body json
    Given Post create new user with valid body json
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 201 created
    And Validate post create new user valid value json schema

    #gagal
  @gorest
  Scenario: Post create user using valid body json without authentication
    Given Post create new user using valid body json without authentication
    When Send post create new user request
    Then Response body should be 401 unauthorized
    And Validate post create new user unauthorized error message json schema
    # Examples:
     # | name | email | gender | status |
     # | Budi | budi@gmail.com  | male  | active  |

  #sukses
  @gorest
  Scenario: Post create user with empty name
    Given Post create new user without input name
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    #And Response body error message should be contain "Name can not blank"
    And Validate post create new user unprocessable json schema
    # Examples:
     # | name | email | gender | status |
     # | | budi@gmail.com  | male  | active  |

  #sukses
  @gorest
  Scenario: Post create user with empty email
    Given Post create new user without input email
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    #And Response body error message should be contain "Email can not blank"
    And Validate post create new user unprocessable json schema
    #Examples:
     # | name | email | gender | status |
     # | Budi | | male  | active  |

  #sukses
  @gorest
  Scenario: Post create user with empty gender
    Given Post create new user without input gender
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    #And Response body error message should be contain "Gender can not blank"
    And Validate post create new user unprocessable json schema
    #Examples:
     # | name | email | gender | status |
     # | Budi | budi@ycp.com  | | active  |

  #sukses
  @gorest
  Scenario: Post create user with empty status
    Given Post create new user without input status
    And Set authentication token
    When Send post create new user request
    Then Response body code should be 422 Unprocessable Entity
    #And Response body error message should be contain "Status can not blank"
    And Validate post create new user unprocessable json schema
    #Examples:
     # | name | email | gender | status |
     # | Budi | budi@ycp.com  | male | |