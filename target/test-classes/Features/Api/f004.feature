@Fav
Feature: Add Favourites


Scenario:  Get User logtoken from login endpoint

    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200 
    And User should verify the login response body firstName present as "RAJ KUMAR" and get the logtoken saved

Scenario: Verify User get Category List through api

    Given User add headers for category List
    When User send "GET" request for category List endpoint
    Then User should verify the status code is 200 
   And User should verify the category List response message matches "OK" and get the category id of main category Name "Grocery" and the sub category Name of "Fruit & Nuts" saved

Scenario: Verify User get Product List through api

    Given User add headers for product List
    When User add request body for product list with category_id and page no "0"
    And User send "POST" request for product List endpoint
    Then User should verify the status code is 200 
    And User should verify the product List response message matches "OK" with product name of "Happilo 100% Natural Premium California Almonds | Premium Badam Giri"  and save variant id with specifications "500 g"

Scenario: Verify User add products to favorites through api

    Given User add header and bearer authorization for accessing manage Favourite List endpoints
    When User add request body for manage favorites list
    And User send "POST" request for manage favorites List endpoint
    Then User should verify the status code is 200
    And User should verify the manage favorites List response message matches "Product added in your favorites"

Scenario: Verify User get Favourite List through api

    Given User add header and bearer authorization for accessing get Favourite List endpoints
    When User send "GET" request for favourite List endpoint
    Then User should verify the status code is 200
    And User should verify the get favourite List response message matches "Favorites list fetched successfully."
