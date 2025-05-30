package com.stepdefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.endpoints.EndPoints;
import com.globallib.GlobalLib;
import com.groceryapi.pojo.CategoryList_Output_Pojo;
import com.groceryapi.pojo.ChildCatList;
import com.groceryapi.pojo.Datu;
import com.groceryapi.pojo.Options;
import com.groceryapi.pojo.ProductList_Input_Pojo;
import com.groceryapi.pojo.ProductList_Output_Pojo;
import com.groceryapi.pojo.Products;
import com.groceryapi.pojo.Variations;
import com.groceryapi.pojo.getuserfavourites.GetUserFavourites_Output_Pojo;
import com.groceryapi.pojo.manageuserfavourites.ManageUserFavourite_Output_Pojo;
import com.groceryapi.pojo.manageuserfavourites.ManageUserfavourite_Input_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddFavourite_Step extends GlobalLib {

	// categoryList

	@Given("User add headers for category List")
	public void user_add_headers_for_category_list() {

		addHeader("Accept", "application/json");

	}

	@When("User send {string} request for category List endpoint")
	public void user_send_request_for_category_list_endpoint(String reqType) {
		Response response = addRequest(reqType, EndPoints.CATEGORYLIST_URL);
		LoginModule_Step.globaldatas.setResponse(response);

	}

	@Then("User should verify the category List response message matches {string} and get the category id of main category Name {string} and the sub category Name of {string} saved")
	public void user_should_verify_the_category_list_response_message_matches_and_get_the_category_id_of_main_category_name_and_the_sub_category_name_of_saved(
			String message, String mainCategory, String subCategory) {

		CategoryList_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(CategoryList_Output_Pojo.class);

		Assert.assertEquals("categoryList response validation", message, output_Pojo.getMessage());

		ArrayList<Datu> data = output_Pojo.getData();
		for (Datu x : data) {
			if (x.getName().equals(mainCategory)) {
				ArrayList<ChildCatList> child_cat_list = x.getChild_cat_list();
				for (ChildCatList y : child_cat_list) {
					if (y.getName().equals(subCategory)) {
						String categoryId = String.valueOf(y.getId());
						System.out.println("category id " + categoryId);
						LoginModule_Step.globaldatas.setCategoryId(categoryId);
						break;

					}

				}

			}

		}

	}

	// productList

	@Given("User add headers for product List")
	public void user_add_headers_for_product_list() {

		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);

		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User add request body for product list with category_id and page no {string}")
	public void user_add_request_body_for_product_list_with_category_id_and_page_no(String string) {

		ProductList_Input_Pojo input_Pojo = new ProductList_Input_Pojo(LoginModule_Step.globaldatas.getCategoryId(),
				"0");

		addPayload(input_Pojo);
	}

	@When("User send {string} request for product List endpoint")
	public void user_send_request_for_product_list_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.PRODUCTLIST_URL);
		LoginModule_Step.globaldatas.setResponse(response);
		// response.prettyPrint();

	}

	@Then("User should verify the product List response message matches {string} with product name of {string}  and save variant id with specifications {string}")
	public void user_should_verify_the_product_list_response_message_matches_with_product_name_of_and_save_variant_id_with_specifications(
			String message, String productName, String variations) {

		ProductList_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(ProductList_Output_Pojo.class);

		Assert.assertEquals("productlist response validations", message, output_Pojo.getMessage());
		ArrayList<Products> data = output_Pojo.getData();
		for (Products x : data) {
			if (x.getName().equals(productName)) {

				ArrayList<Variations> variations2 = x.getVariations();
				for (Variations y : variations2) {
					if (y.getSpecifications().equals(variations)) {

						ArrayList<Options> options = y.getOptions();
						for (Options z : options) {

							String product_id = String.valueOf(z.getProduct_id());

							LoginModule_Step.globaldatas.setProductId(product_id);

							String variation_id = String.valueOf(z.getVariation_id());

							LoginModule_Step.globaldatas.setVarientId(variation_id);

							System.out.println("product_id " + product_id);
							System.out.println("variation_id " + variation_id);

							break;

						}

					}

				}

			}

		}

	}

	// add product to fav
	@Given("User add header and bearer authorization for accessing manage Favourite List endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_manage_favourite_list_endpoints() {

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

	@When("User add request body for manage favorites list")
	public void user_add_request_body_for_manage_favorites_list() {

		ManageUserfavourite_Input_Pojo input_Pojo = new ManageUserfavourite_Input_Pojo(
				LoginModule_Step.globaldatas.getProductId(), LoginModule_Step.globaldatas.getVarientId());

		addPayload(input_Pojo);

	}

	@When("User send {string} request for manage favorites List endpoint")
	public void user_send_request_for_manage_favorites_list_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.MANAGEUSERFAV_URL);
		LoginModule_Step.globaldatas.setResponse(response);

	}

	@Then("User should verify the manage favorites List response message matches {string}")
	public void user_should_verify_the_manage_favorites_list_response_message_matches(String message) {

		ManageUserFavourite_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(ManageUserFavourite_Output_Pojo.class);

		Assert.assertEquals("manage fav response validations", message, output_Pojo.getMessage());
	}

	// get fav list

	@Given("User add header and bearer authorization for accessing get Favourite List endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_get_favourite_list_endpoints() {

		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());
		
		list.add(h1);
		list.add(h2);
		
		Headers headers = new Headers(list);

		addHeaders(headers);
	}

	@When("User send {string} request for favourite List endpoint")
	public void user_send_request_for_favourite_list_endpoint(String reqType) {
		
		Response response = addRequest(reqType,EndPoints.GETUSERFAVOURITES_URL );
		LoginModule_Step.globaldatas.setResponse(response);

	}

	@Then("User should verify the get favourite List response message matches {string}")
	public void user_should_verify_the_get_favourite_list_response_message_matches(String message) {
		
		GetUserFavourites_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(GetUserFavourites_Output_Pojo.class);
		
		Assert.assertEquals("favourite list response validations", message,output_Pojo.getMessage() );
		
		

	}

}
