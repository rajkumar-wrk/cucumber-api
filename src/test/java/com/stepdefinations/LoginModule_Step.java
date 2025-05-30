package com.stepdefinations;

import java.io.IOException;

import org.junit.Assert;

import com.Globaldatas.Globaldatas;
import com.apiclass.pojo.PostmanBasicAuthenLogin_Output_Pojo;
import com.endpoints.EndPoints;
import com.globallib.GlobalLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class LoginModule_Step extends GlobalLib {

	
	static Globaldatas globaldatas=new Globaldatas();
	

	@Given("User add header")
	public void user_add_header() {
		addHeader("accept", "application/json");
	   
	}
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws IOException  {
		
		String user = propertyReadValues("userName");
		
		String pass = propertyReadValues("passWord");
		
		addBasicAuthen(user,pass);
	}
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String requestType) {
		 Response response = addRequest(requestType, EndPoints.LOGIN_URL);
		// response.prettyPrint();
		 globaldatas.setResponse(response);
	}
	
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void user_should_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken_saved(String fistName) {
	   
		Response res = globaldatas.getResponse();
		PostmanBasicAuthenLogin_Output_Pojo login_Output_Pojo = res.as(PostmanBasicAuthenLogin_Output_Pojo.class);
		Assert.assertEquals("First name validations", fistName, login_Output_Pojo.getData().getFirst_name());

		System.out.println(login_Output_Pojo.getData().getFirst_name());
		
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		
		globaldatas.setLogToken(logtoken);
	}



}
