package com.stepdefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.Globaldatas.Globaldatas;
import com.apiclass.pojoaddress.CityList;
import com.apiclass.pojoaddress.CityList_Input_Pojo;
import com.apiclass.pojoaddress.CityList_Output_Pojo;
import com.apiclass.pojoaddress.DeleteUserAddress_Input_Pojo;
import com.apiclass.pojoaddress.DeleteUserAddress_Output_Pojo;
import com.apiclass.pojoaddress.GetUserAddress_Output_pojo;
import com.apiclass.pojoaddress.StateList;
import com.apiclass.pojoaddress.StateList_Output_Pojo;
import com.apiclass.pojoaddress.UpdateUserAddress_Output_Pojo;
import com.apiclass.pojoaddress.UpdateUserAddress_input_pojo;
import com.apiclass.pojoaddress.addUserAddress_Output_pojo;
import com.apiclass.pojoaddress.addUserAdress_Input_Pojo;
import com.endpoints.EndPoints;
import com.globallib.GlobalLib;


import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddressModule_Step extends GlobalLib {

	// stateList
	@Given("User add headers for to StateList")
	public void user_add_headers_for_to_state_list() {
		addHeader("accept", "application/json");

	}

	@When("User send {string} request for StateList endpoint")
	public void user_send_request_for_state_list_endpoint(String reqType) {
		Response response = addRequest(reqType, EndPoints.STATELIST_URL);
		LoginModule_Step.globaldatas.setResponse(response);
		// response.prettyPrint();

	}

	@Then("User should verify the stateList response message matches {string} and saved state id")
	public void user_should_verify_the_state_list_response_message_matches_and_saved_state_id(String stateName) {
		Response response = LoginModule_Step.globaldatas.getResponse();
		StateList_Output_Pojo output_Pojo = response.as(StateList_Output_Pojo.class);

		ArrayList<StateList> data = output_Pojo.getData();

		for (StateList x : data) {

			if (x.getName().equals(stateName)) {

				Assert.assertEquals("state name validations", stateName, x.getName());
				LoginModule_Step.globaldatas.setStateId(String.valueOf(x.getId()));
				break;

			}

		}

		// System.out.println(LoginModule_Step.globaldatas.getStateId());

	}

	// cityList

	@Given("User add header  for to get CityList")
	public void user_add_header_for_to_get_city_list() {
		ArrayList<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");

		Header h2 = new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);

		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User add request body state id for  get city list")
	public void user_add_request_body_state_id_for_get_city_list() {
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(LoginModule_Step.globaldatas.getStateId());
		addPayload(cityList_Input_Pojo);

	}

	@When("User send {string} request for CityList endpoint")
	public void user_send_request_for_city_list_endpoint(String reqType) {
		Response res = addRequest(reqType, EndPoints.CITYLIST_URL);
		LoginModule_Step.globaldatas.setResponse(res);

	}

	@Then("User verify the cityList response message matches {string} and saved city id")
	public void user_verify_the_city_list_response_message_matches_and_saved_city_id(String cityName) {
		Response response = LoginModule_Step.globaldatas.getResponse();
		CityList_Output_Pojo output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> data = output_Pojo.getData();
		for (CityList x : data) {
			if (x.getName().equals(cityName)) {
				Assert.assertEquals("city name validation", cityName, x.getName());

				LoginModule_Step.globaldatas.setCityId(String.valueOf(x.getId()));
				break;

			}

		}
	}

	// addAdress

	@Given("User add header and bearer authorizations for accessing address endpoints")
	public void user_add_header_and_bearer_authorizations_for_accessing_address_endpoints() {

		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);
		list.add(h3);
		Headers headers = new Headers(list);

		addHeaders(headers);
	}

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_add_request_body_for_add_new_address_and_work(String firstName, String lastName, String mobile,
			String apartment, String state, String city, String country, String zipCode, String address,
			String addType) {

		int stateId = Integer.parseInt(LoginModule_Step.globaldatas.getStateId());
		int cityId = Integer.parseInt(LoginModule_Step.globaldatas.getCityId());
		int countryyId = Integer.parseInt(country);

		addUserAdress_Input_Pojo input_Pojo = new addUserAdress_Input_Pojo(firstName, lastName, mobile, apartment,
				stateId, cityId, countryyId, zipCode, address, addType);

		addPayload(input_Pojo);

	}

	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.ADDUSERADDRESS_URL);
		LoginModule_Step.globaldatas.setResponse(response);

	}

	@Then("User should verify the addUserAddress response message matches {string} and get the address id saved")
	public void user_should_verify_the_add_user_address_response_message_matches_and_get_the_address_id_saved(
			String message) {

		addUserAddress_Output_pojo output_pojo = LoginModule_Step.globaldatas.getResponse()
				.as(addUserAddress_Output_pojo.class);

		Assert.assertEquals(" response message validation", message, output_pojo.getMessage());

		String addId = String.valueOf(output_pojo.getAddress_id());
		LoginModule_Step.globaldatas.setAddressId(addId);

	}

	// update

	@Given("User add header and bearer authorization for accessing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoint() {

		ArrayList<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);
		list.add(h3);
		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User add request body to update new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_add_request_body_to_update_new_address_and_home(String firstName, String lastName, String mobile,
			String apartment, String state, String city, String country, String zipCode, String address,
			String addType) {

		int stateId = Integer.parseInt(LoginModule_Step.globaldatas.getStateId());
		int cityId = Integer.parseInt(LoginModule_Step.globaldatas.getCityId());
		int countryyId = Integer.parseInt(country);
		UpdateUserAddress_input_pojo input_pojo = new UpdateUserAddress_input_pojo(
				LoginModule_Step.globaldatas.getAddressId(), firstName, lastName, mobile, apartment, stateId, cityId,
				countryyId, zipCode, address, addType);

		addPayload(input_pojo);

	}

	@When("User send {string} request for update addUserAddress endpoint")
	public void user_send_request_for_update_add_user_address_endpoint(String reqType) {
		
		Response response = addRequest(reqType, EndPoints.UPDATEUSERADRESS_URL);
		LoginModule_Step.globaldatas.setResponse(response);

	}

	@Then("User verify the update address response message matches {string}")
	public void user_verify_the_update_address_response_message_matches(String message) {
		
		Response response = LoginModule_Step.globaldatas.getResponse();
		UpdateUserAddress_Output_Pojo output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		Assert.assertEquals("update message validations",message,output_Pojo.getMessage());

	}

	// getaddress

	@Given("User add Headers and Bearer authorization for access Get address endpoints")
	public void user_add_headers_and_bearer_authorization_for_access_get_address_endpoints() {
		ArrayList<Header> l=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer "+LoginModule_Step.globaldatas.getLogToken());
		l.add(h1);l.add(h2);
		
		Headers headers = new Headers(l);
		addHeaders(headers);
	}

	@When("User Send {string} request for GetUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String reqType) {
		Response response = addRequest(reqType,EndPoints.GETUSERADDRESS_URL);
		LoginModule_Step.globaldatas.setResponse(response);
	}

	@Then("User verify the GetUserAddress response message matches {string}")
	public void user_verify_the_get_user_address_response_message_matches(String message) {
		
		Response response = LoginModule_Step.globaldatas.getResponse();
		GetUserAddress_Output_pojo output_pojo = response.as(GetUserAddress_Output_pojo.class);
		Assert.assertEquals("get user message validations",message,output_pojo.getMessage());
		
	}

	
	
	
	// delete address
	@Given("User add header and bearer authorization  accessing address endpoints")
	public void user_add_header_and_bearer_authorization_accessing_address_endpoints() {
		
		ArrayList<Header>list=new ArrayList<Header>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization","Bearer "+LoginModule_Step.globaldatas.getLogToken());
		Header h3=new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);
		list.add(h3);
		Headers headers=new Headers(list);
		addHeaders(headers);
		
	}

	@When("User add request body for address id")
	public void user_add_request_body_for_address_id() {
		
		DeleteUserAddress_Input_Pojo input_Pojo=new DeleteUserAddress_Input_Pojo(LoginModule_Step.globaldatas.getAddressId());
		addPayload(input_Pojo);
		
	}

	@When("User Send {string} request for DeleteAddress endpoint")
	public void user_send_request_for_delete_address_endpoint(String reqType) {
		Response response = addRequest(reqType, EndPoints.DELETEADDRESS_URL);
		LoginModule_Step.globaldatas.setResponse(response);
		
		
	}

	@Then("User verify the DeleteAddress response message matches {string}")
	public void user_verify_the_delete_address_response_message_matches(String message) {
		Response response = LoginModule_Step.globaldatas.getResponse();
		DeleteUserAddress_Output_Pojo output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		
		Assert.assertEquals("delete address message vaidalations",message ,output_Pojo.getMessage());
		
	}

}
