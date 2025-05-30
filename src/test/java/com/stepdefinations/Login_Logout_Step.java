package com.stepdefinations;

import java.util.ArrayList;

import org.junit.Assert;

import com.api.pojologinlogout.Logout_Output_Pojo;
import com.endpoints.EndPoints;
import com.globallib.GlobalLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Login_Logout_Step  extends GlobalLib{
	
	@Given("User add header for Logout")
	public void user_add_header_for_logout() {
		ArrayList<Header>list=new ArrayList<Header>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer "+LoginModule_Step.globaldatas.getLogToken());
		list.add(h1);list.add(h2);
		
		Headers headers=new Headers(list);
		addHeaders(headers);
	    
	}
	@When("User send {string} request for logout endpoint")
	public void user_send_request_for_logout_endpoint(String reqType) {
		Response response = addRequest(reqType, EndPoints.LOGOUT_URL);
		LoginModule_Step.globaldatas.setResponse(response);
	   
	}
	@Then("User should verify the logout response message {string}")
	public void user_should_verify_the_logout_response_message(String message) {
		
		Logout_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(Logout_Output_Pojo.class);
		
		Assert.assertEquals("logout response validations", message, output_Pojo.getMessage());
	    
	}




}
