
@Fav
Feature: Remove favourites


Scenario:  Get User logtoken from login endpoint

    Given User add header 
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200 
    And User should verify the login response body firstName present as "RAJ KUMAR" and get the logtoken saved

Scenario: Verify User remove products to favorites through api

    Given User add header and bearer authorization for accessing manage Favourite List endpoints
    When User add request body for manage favorites list
    And User send "POST" request for manage favorites List endpoint
    Then User should verify the status code is 200 
    And User should verify the manage favorites List response message matches "Product removed from your favorites"

Scenario: Verify User not seeing products are in Favourite List through api

   Given User add header and bearer authorization for accessing get Favourite List endpoints
   When User send "GET" request for favourite List endpoint
   Then User should verify the status code is 400 
   And User should verify the no product favourite List response message matches "No favorites found"
