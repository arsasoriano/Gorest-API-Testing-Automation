Feature: GoRest Feature test
@ToDos
Scenario:Post to do is
When Set path without token
And Click send button without token
Then API should return response 200 OK
@ToDos
Scenario:Post to do is
When Set path with token
And Click send button with token
Then API should return response 200 OK
@ToDos
Scenario:Post to do is
When Set path to id in body field as integer
And Click send button with token
Then API should return response 200 OK
@ToDos
Scenario:Post to do is
When Set path to id in body field as string
And Click send button with token
Then API should return response 400 Not Found
@ToDos
Scenario:Post to do is
When Set path to ID in body
And Click send button with token
Then API should return response 200 OK
@ToDos
Scenario:Post to do is
When Set path to USER_ID in body
And Click send button with token
Then API should return response 200 Unprocessable Entity
@ToDos
Scenario:Post to do is
When Set path to user_id in body as string
And Click send button with token
Then API should return response 400 Not Found
@ToDos
Scenario:Post to do is
When Set path to user_id in body as special character
And Click send button with token
Then API should return response 400 Not Found