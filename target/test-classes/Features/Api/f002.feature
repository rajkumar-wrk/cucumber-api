@Address
Feature: Address Module


Scenario:  Get User logtoken from login endpoint

    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200 
    And User should verify the login response body firstName present as "RAJ KUMAR" and get the logtoken saved

@SearchCreateOrder @CategoryCreateOrder @CancelOrder
Scenario:  Verify User Get StateList  through api
    
    Given User add headers for to StateList
    When User send "GET" request for StateList endpoint
    Then User should verify the status code is 200 
    And User should verify the stateList response message matches "Tamil Nadu" and saved state id
    
@SearchCreateOrder @CategoryCreateOrder @CancelOrder
Scenario:   Verify User Get City list  through api
	   
    Given User add header  for to get CityList
    When User add request body state id for  get city list
    And User send "POST" request for CityList endpoint
    Then User should verify the status code is 200 
    And User verify the cityList response message matches "Chennai" and saved city id

Scenario Outline:  Verify add user address to the application through api
    
    Given User add header and bearer authorizations for accessing address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddress response message matches "Address added successfully" and get the address id saved

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |Raj         |Kumar      |1234567898  |yesodha        |33     |3378  |101      |607803   |chennai  |work          |


Scenario Outline:  Verify update user address to the application through api

    Given User add header and bearer authorization for accessing address endpoint
    When User add request body to update new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    And User send "PUT" request for update addUserAddress endpoint
    Then User should verify the status code is 200
    Then User verify the update address response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |RAJ         |kUMAR      |1234567898  |YESODHA    |33     |3378  |101      |607803   |CUDDALORE| HOME         |


Scenario:  Verify Get User Address to the application through API

    Given User add Headers and Bearer authorization for access Get address endpoints
    When User Send "GET" request for GetUserAddress endpoint
    Then User should verify the status code is 200 
    Then User verify the GetUserAddress response message matches "OK"

Scenario:  Verify Delete User Address to the application through API

    Given User add header and bearer authorization  accessing address endpoints
    When User add request body for address id
    And User Send "DELETE" request for DeleteAddress endpoint
    Then User should verify the status code is 200 
    Then User verify the DeleteAddress response message matches "Address deleted successfully"
