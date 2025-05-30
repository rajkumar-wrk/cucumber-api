package com.stepdefinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.endpoints.EndPoints;
import com.globallib.GlobalLib;
import com.groceryapi.pojo.AddToCart_Input_Pojo;
import com.groceryapi.pojo.Cart;
import com.groceryapi.pojo.CreateOrderId_Input_Pojo;
import com.groceryapi.pojo.CreateOrderId_Output_Pojo;
import com.groceryapi.pojo.Datum;
import com.groceryapi.pojo.GetCartItems_Output_Pojo;
import com.groceryapi.pojo.Option;
import com.groceryapi.pojo.Product;
import com.groceryapi.pojo.SearchProduct_Input_Pojo;
import com.groceryapi.pojo.SearchProduct_Output_Pojo;
import com.groceryapi.pojo.SetAddress_Input_Pojo;
import com.groceryapi.pojo.Variation;
import com.groceryapi.pojo.getSearchResult_Input_Pojo;
import com.groceryapi.pojo.getSearchResult_Output_Pojo;
import com.groceryapi.pojo.setAddress_Output_Pojo;
import com.groceryapi.pojo.addtocart.AddToCart_Output_Pojo;
import com.groceryapi.pojo.clearcart.ClearCart_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class SearchCreateOrder_Step extends GlobalLib {
	// clearCart

	@Given("User add header and bearer authorization for accessing clear cart endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_clear_cart_endpoints() {

		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());

		list.add(h1);
		list.add(h2);

		Headers headers = new Headers(list);

		addHeaders(headers);

	}

	@When("User send {string} request for clear cart endpoint")
	public void user_send_request_for_clear_cart_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.CLEARCART_URL);
		LoginModule_Step.globaldatas.setResponse(response);
		response.prettyPrint();

	}

	@Then("User should verify the response message {string}")
	public void user_should_verify_the_response_message(String message) {

		ClearCart_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(ClearCart_Output_Pojo.class);

		Assert.assertEquals("clear cart validations", message, output_Pojo.getMessage());

	}

//Search product
	@Given("User add headers for search product")
	public void user_add_headers_for_search_product() {

		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);
		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User add request body for search product {string}")
	public void user_add_request_body_for_search_product(String product) {

		SearchProduct_Input_Pojo input_Pojo = new SearchProduct_Input_Pojo(product);
		addPayload(input_Pojo);

	}

	@When("User send {string} request for search product endpoint")
	public void user_send_request_for_search_product_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.SEARCHPRODUCT_URL);

		LoginModule_Step.globaldatas.setResponse(response);

		// response.prettyPrint();

	}

	@Then("User should verify the search product response message matches {string} and save category id and product id with category name {string}")
	public void user_should_verify_the_search_product_response_message_matches_and_save_category_id_and_product_id_with_category_name(
			String message, String productname) {

		SearchProduct_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(SearchProduct_Output_Pojo.class);

		Assert.assertEquals("search product response validations", message, output_Pojo.getMessage());

		ArrayList<Product> data = output_Pojo.getData();
		for (Product x : data) {
			if (x.getText().equals(productname)) {

				LoginModule_Step.globaldatas.setCategoryId(String.valueOf(x.getCategory_id()));
				LoginModule_Step.globaldatas.setProductId(String.valueOf(x.getId()));
				break;

			}

		}

	}

	//// get search product
	@Given("User add header and bearer authorization for accessing get search product List endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_get_search_product_list_endpoints() {

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

	@When("User add request body for get search product")
	public void user_add_request_body_for_get_search_product() {

		getSearchResult_Input_Pojo input_Pojo = new getSearchResult_Input_Pojo(
				LoginModule_Step.globaldatas.getCategoryId(), LoginModule_Step.globaldatas.getProductId(), "category");

		addPayload(input_Pojo);
	}

	@When("User send {string} request for get search product List endpoint")
	public void user_send_request_for_get_search_product_list_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.GETSEARCHRESULT_URL);

		LoginModule_Step.globaldatas.setResponse(response);

		// response.prettyPrint();

	}

	@Then("User should verify the get search product response message matches {string} with product id and save variant id with specifications {string}")
	public void user_should_verify_the_get_search_product_response_message_matches_with_product_id_and_save_variant_id_with_specifications(
			String message, String variantByGrams) {

		getSearchResult_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(getSearchResult_Output_Pojo.class);

		Assert.assertEquals("get search product", message, output_Pojo.getMessage());

		ArrayList<Datum> data = output_Pojo.getData();
		for (Datum x : data) {
			if (x.getId() == Integer.parseInt(LoginModule_Step.globaldatas.getProductId())) {

				ArrayList<Variation> variations = x.getVariations();
				for (Variation y : variations) {
					if (y.getSpecifications().equals(variantByGrams)) {

						ArrayList<Option> options = y.getOptions();
						for (Option z : options) {
							LoginModule_Step.globaldatas.setVarientId(String.valueOf(z.getVariation_id()));
							break;

						}

					}

				}

			}

		}
	}

	// addtocart

	@Given("User add header and bearer authorization for accessing add to cart endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_add_to_cart_endpoints() {

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

	@When("User add request body for add to cart")
	public void user_add_request_body_for_add_to_cart() {
		AddToCart_Input_Pojo input_Pojo = new AddToCart_Input_Pojo(LoginModule_Step.globaldatas.getProductId(),
				LoginModule_Step.globaldatas.getVarientId(), "plus");

		addPayload(input_Pojo);

	}

	@When("User send {string} request for add to cart endpoint")
	public void user_send_request_for_add_to_cart_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.ADDTOCART_URL);

		LoginModule_Step.globaldatas.setResponse(response);

		// response.prettyPrint();

	}

	@Then("User should verify the add to cart response message matches {string}")
	public void user_should_verify_the_add_to_cart_response_message_matches(String message) {

		AddToCart_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse().as(AddToCart_Output_Pojo.class);
		Assert.assertEquals("add to cart validations", message, output_Pojo.getMessage());
	}

	// getcart

	@Given("User add header and bearer authorization for accessing get cart endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_get_cart_endpoints() {

		ArrayList<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());
		list.add(h1);
		list.add(h2);
		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User send {string} request for get cart endpoint")
	public void user_send_request_for_get_cart_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.GETCARTITEMS_URL);

		LoginModule_Step.globaldatas.setResponse(response);

		// response.prettyPrint();

	}

	@Then("User should verify the get cart response message matches {string} and save the cart id")
	public void user_should_verify_the_get_cart_response_message_matches_and_save_the_cart_id(String message) {

		GetCartItems_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(GetCartItems_Output_Pojo.class);

		Assert.assertEquals("getcart response validations", message, output_Pojo.getMessage());

		ArrayList<Cart> data = output_Pojo.getData();
		for (Cart x : data) {
			if (x.getProduct_id() == Integer.parseInt(LoginModule_Step.globaldatas.getProductId())) {

				LoginModule_Step.globaldatas.setCartId(String.valueOf(x.getCart_id()));
				break;

			}

		}

	}

	// setaddress

	@Given("User add header and bearer authorization for accessing set address endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_set_address_endpoints() {
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

	@When("User add request body for set address product")
	public void user_add_request_body_for_set_address_product() {

		SetAddress_Input_Pojo input_Pojo = new SetAddress_Input_Pojo(LoginModule_Step.globaldatas.getAddressId(),
				LoginModule_Step.globaldatas.getCartId());
		addPayload(input_Pojo);

	}

	@When("User send {string} request for set address endpoint")
	public void user_send_request_for_set_address_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.SETADDRESS_URL);

		LoginModule_Step.globaldatas.setResponse(response);
		response.prettyPrint();

	}

	@Then("User should verify the set address response message matches {string}")
	public void user_should_verify_the_set_address_response_message_matches(String message) {

		setAddress_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(setAddress_Output_Pojo.class);

		Assert.assertEquals("set address response validation", message, output_Pojo.getMessage());

	}

	// create order

	@Given("User add header and bearer authorization for accessing create order endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_create_order_endpoints() {

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

	@When("User add request body for create order product")
	public void user_add_request_body_for_create_order_product(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(0);

		CreateOrderId_Input_Pojo input_Pojo = new CreateOrderId_Input_Pojo(map.get("Card Type"), map.get("CardNo"),
				map.get("Select card"), map.get("Year"), map.get("Month"), map.get("CVV"));

		addPayload(input_Pojo);
	}

	@When("User send {string} request for create order endpoint")
	public void user_send_request_for_create_order_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.CREATEORDER_URL);
		

		LoginModule_Step.globaldatas.setResponse(response);
		response.prettyPrint();
		

	}

	@Then("User should verify the create order response message matches {string} and save order no")
	public void user_should_verify_the_create_order_response_message_matches_and_save_order_no(String message)  {

		CreateOrderId_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(CreateOrderId_Output_Pojo.class);
		
		Assert.assertEquals("create order response validations", message,output_Pojo.getMessage());
		
		LoginModule_Step.globaldatas.setOrderId(String.valueOf(output_Pojo.getOrder_id()));
		
		
		
		

	}

}
