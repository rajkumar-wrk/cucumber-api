package com.stepdefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.endpoints.EndPoints;
import com.globallib.GlobalLib;
import com.groceryapi.pojo.CancelOrder_Input_Pojo;
import com.groceryapi.pojo.CancelOrder_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CancelOrder_Step extends GlobalLib {

	@Given("User add header and bearer authorization for accessing cancel Order endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_cancel_order_endpoints() {

		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");

		list.add(h1);
		list.add(h2);
		list.add(h3);
		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User add request body for cancel Order")
	public void user_add_request_body_for_cancel_order() {

		CancelOrder_Input_Pojo input_Pojo = new CancelOrder_Input_Pojo(LoginModule_Step.globaldatas.getOrderId());

		addPayload(input_Pojo);
	}

	@When("User send {string} request for cancel order endpoint")
	public void user_send_request_for_cancel_order_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.CANCELORDER_URL);
		
		LoginModule_Step.globaldatas.setResponse(response);
		
	}

	@Then("User should verify the cancel order response message matches {string}")
	public void user_should_verify_the_cancel_order_response_message_matches(String message) {
		
		CancelOrder_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(CancelOrder_Output_Pojo.class);

		Assert.assertEquals("cancel order response validations", message,output_Pojo.getMessage());
	}

}
