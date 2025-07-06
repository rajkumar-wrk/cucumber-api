@ChangeProfile @Login
Feature: Change Profile Module


Scenario:  Get User logtoken from login endpoint

    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200 
    And User should verify the login response body firstName present as "RAJ KUMAR" and get the logtoken saved

Scenario: Verify User post change profile picture  through api

    Given User add header and bearer authorization for accessing change profile picture endpoints
    When User add request body for change profile picture
    And User send "POST" request for change profile endpoint
    Then User should verify the status code is 200 
    And User should verify the change profile picture response message matches "Profile updated Successfully"