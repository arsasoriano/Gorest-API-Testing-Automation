Feature: Post New Comments Test
  Scenario: Create new comments with valid URL
    Given Create new comments with valid json
    And Set Authentication
    When send create request new comments and set authentication
    #And Click send button
    Then API should return response 201 Created
    And API should return body page post_id 2305, name "Tej Shah", email "tej_shah@roberts.org", body "Qui optio est. Molestiae voluptatibus ipsam"