package com.stepdefinations;

import org.junit.Assert;

import com.Globaldatas.Globaldatas;
import com.globallib.GlobalLib;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class CommonStep extends GlobalLib {

	
	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int statusCode) {
		Response res = LoginModule_Step.globaldatas.getResponse();
		
		Assert.assertEquals("status code validation", statusCode, res.getStatusCode());
		//res.prettyPrint();
		
	}
}
