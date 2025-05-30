package com.stepdefinations;

import org.junit.Assert;

import com.globallib.GlobalLib;
import com.groceryapi.pojo.getuserfavourites.GetUserFavourites_Output_Pojo;

import io.cucumber.java.en.*;

public class RemoveFavourites_Step extends GlobalLib {

	@Then("User should verify the no product favourite List response message matches {string}")
	public void user_should_verify_the_no_product_favourite_list_response_message_matches(String message) {
		
		GetUserFavourites_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(GetUserFavourites_Output_Pojo.class);

		Assert.assertEquals("get fav lists validations",message,output_Pojo.getMessage());
	}

}
