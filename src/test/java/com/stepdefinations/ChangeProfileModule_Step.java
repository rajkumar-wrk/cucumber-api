package com.stepdefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.endpoints.EndPoints;
import com.globallib.GlobalLib;
import com.groceryapi.pojo.changeprofilepicture.ChangeProfilePic_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ChangeProfileModule_Step extends GlobalLib {
	
	

	@Given("User add header and bearer authorization for accessing change profile picture endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_change_profile_picture_endpoints() {
		
		List<Header>list=new ArrayList<Header>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer "+LoginModule_Step.globaldatas.getLogToken());
		Header h3=new Header("Content-Type", "multipart/form-data");
		list.add(h1);
		list.add(h2);
		list.add(h3);
	
		Headers headers=new Headers(list);
		
		addHeaders(headers);
		
	
	}
	@When("User add request body for change profile picture")
	public void user_add_request_body_for_change_profile_picture() {
		multiPart("profile_picture","api.png" );
		
		
	    
	}
	@When("User send {string} request for change profile endpoint")
	public void user_send_request_for_change_profile_endpoint(String reqType) {
		
		Response response = addRequest(reqType,EndPoints.CHANGEPROFILEPIC_URL);
		
		LoginModule_Step.globaldatas.setResponse(response);
	
	
	}
	
	@Then("User should verify the change profile picture response message matches {string}")
	public void user_should_verify_the_change_profile_picture_response_message_matches(String message) {
		
		ChangeProfilePic_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(ChangeProfilePic_Output_Pojo.class);
	   
		Assert.assertEquals("change profile message validations",message,output_Pojo.getMessage());
		
		
	}




}
