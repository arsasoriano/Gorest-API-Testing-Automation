Feature: GoRest Feature test
@ToDos
Scenario: Put to do is
When Set path for put without token
Then API should return response 404 Not Found
@ToDos
Scenario: Put to do is
When Set path for put with token
Then API should return response 404 Not Found
@ToDos
Scenario: Patch to do is
When Set path for patch without token
Then API should return response 404 Not Found
@ToDos
Scenario: Patch to do is
When Set path for patch with token
Then API should return response 404 Not Found
@ToDos
Scenario: Delete to do is
When Set path for delete without token
Then API should return response 404 Not Found
@ToDos
Scenario: Delete to do is
When Set path for delete with token
Then API should return response 404 Not Found