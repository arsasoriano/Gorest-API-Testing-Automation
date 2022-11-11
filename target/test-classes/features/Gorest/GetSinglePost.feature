Feature: Get single post
  #sukses
  @gorest
  Scenario: Get single post with valid id
    Given Get single post with id 1792
    When Send request to get single post
    Then Should return 200 OK
    And Response body should contain id 1792 with user id 3780 and title "Vergo arbustum temporibus cito cum cresco supellex pauci desidero ullus adflicto sequi."
    And Validate get single post with json schema validator

  #sukses
  @gorest
  Scenario: Get single post with invalid id by alphabet
    Given Get single post with invalid id using alphabet "<id>"
    When Send request to get single post
    Then Should return 404 not found

