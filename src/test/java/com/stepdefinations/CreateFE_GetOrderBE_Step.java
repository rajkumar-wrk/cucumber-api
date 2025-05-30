package com.stepdefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import org.junit.Assert;

import com.apiclass.pojo.Login;
import com.endpoints.EndPoints;
import com.globallib.GlobalLib;
import com.groceryapi.pojo.GetAllOrders_Output_Pojo;
import com.groceryapi.pojo.GetOrderDetails_Output_Pojo;
import com.groceryapi.pojo.Orders;
import com.groceryapi.pojo.Prodcts;
import com.groceryapi.pom.LoginPage;
import com.groceryapi.pom.MyCartPage;
import com.groceryapi.pom.OrderIdPage;
import com.groceryapi.pom.ProductListingPage;
import com.groceryapi.pom.SearchProductPage;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CreateFE_GetOrderBE_Step extends GlobalLib {

	// fe

	@Given("User is on the OMR Branch hotel page")
	public void user_is_on_the_omr_branch_hotel_page(io.cucumber.datatable.DataTable dataTable) {
		List<String> asList = dataTable.asList();

		ChromeDriver(asList.get(0));

	}

	@When("User should login {string},{string}")
	public void user_should_login(String string, String string2) throws IOException {

		LoginPage page = new LoginPage();

		page.login(propertyReadValues("userName"), propertyReadValues("passWord"));

	}

	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String txt) {

		LoginPage page = new LoginPage();
		Assert.assertEquals("homepage validations", txt, page.getTxtWelcome().getText());
		page.grocery();

	}

	@When("User enter search keyword {string} for product")
	public void user_enter_search_keyword_for_product(String product) {

		SearchProductPage page = new SearchProductPage();
		page.searchProduct(product);

	}

	@When("User select the product name contains {string} from the product list")
	public void user_select_the_product_name_contains_from_the_product_list(String productName) {

		ProductListingPage listingPage = new ProductListingPage();
		if (listingPage.getTxtHappilo().getText().equals(productName)) {
			elementClick(listingPage.getBtnHappilo());

		}

	}

	@When("User added the product to cart")
	public void user_added_the_product_to_cart() {
		ProductListingPage listingPage = new ProductListingPage();

		elementClick(listingPage.getBtnHappilo500gms());
		jsClick(listingPage.getBtnGoToCart());

	}

	@When("User add new address {string},{string},{string},{string},{string},{string},{string},{string},{string}{string}")
	public void user_add_new_address(String firstName, String lastName, String mobile, String apartment, String state,
			String city, String country, String zipcode, String address, String addressType)
			throws InterruptedException {

		MyCartPage page = new MyCartPage();
		page.myCart(firstName, lastName, mobile, apartment, state, city, zipcode, addressType, address);

	}

	@When("User enter payment details, procced with card type")
	public void user_enter_payment_details_procced_with_card_type(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(0);

		MyCartPage cartPage = new MyCartPage();
		cartPage.payment(map.get("cardType"), map.get("CardNo"), map.get("Month"), map.get("Year"), map.get("CVV"));

	}

	@Then("User should verify order placed success message contains {string} and save Order number")
	public void user_should_verify_order_placed_success_message_contains_and_save_order_number(String string)
			throws IOException {

		OrderIdPage idPage = new OrderIdPage();

		String orderNo = idPage.getOrderId(propertyReadValues("userName"), propertyReadValues("passWord")).substring(10);
//System.out.println("orderNo "+orderNo);
		LoginModule_Step.globaldatas.setOrderNo(orderNo);
	}

	// getallorders

	@Given("User add header and bearer authorization for accessing get all the Order endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_get_all_the_order_endpoints() {
		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginModule_Step.globaldatas.getLogToken());

		list.add(h1);
		list.add(h2);

		Headers headers = new Headers(list);
		addHeaders(headers);

	}

	@When("User send {string} request for get all order endpoint")
	public void user_send_request_for_get_all_order_endpoint(String reqType) {

		Response response = addRequest(reqType, EndPoints.GETALLORDERS_URL);

		LoginModule_Step.globaldatas.setResponse(response);

		// response.prettyPrint();
	}

	@Then("User should verify the get all order response message matches {string} and save the order id using order no")
	public void user_should_verify_the_get_all_order_response_message_matches_and_save_the_order_id_using_order_no(
			String message) {

		GetAllOrders_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(GetAllOrders_Output_Pojo.class);

		Assert.assertEquals("get all orders response validations", message, output_Pojo.getMessage());

		ArrayList<Orders> data = output_Pojo.getData();

		for (Orders x : data) {
			if (x.getOrder_no().equals(LoginModule_Step.globaldatas.getOrderNo())) {
				LoginModule_Step.globaldatas.setOrderId(String.valueOf(x.getId()));
				//System.out.println("orderID "+x.getId());
				break;

			}

		}

	}

	// getSpecific order

	@When("User pass order id as query param")
	public void user_pass_order_id_as_query_param() {

		System.out.println("user pass order id as query param");

	}

	@When("User send {string} request for get specific order endpoint")
	public void user_send_request_for_get_specific_order_endpoint(String reqType) {

		Response request = addRequest(reqType,
				EndPoints.GETORDERDETAILS_PATHPARAM_URL + LoginModule_Step.globaldatas.getOrderId());

		LoginModule_Step.globaldatas.setResponse(request);
		
		request.prettyPrint();

	}

	@Then("User should verify the get all order response message matches {string} and verify the product name {string}")
	public void user_should_verify_the_get_all_order_response_message_matches_and_verify_the_product_name(
			String message, String productName) {

		GetOrderDetails_Output_Pojo output_Pojo = LoginModule_Step.globaldatas.getResponse()
				.as(GetOrderDetails_Output_Pojo.class);
		
		
		Assert.assertEquals("specific order response validations", message, output_Pojo.getMessage());
		
		ArrayList<Prodcts> products = output_Pojo.getProducts();
		for (Prodcts x : products) {
			if (x.getName().equals(productName)) {
				Assert.assertEquals("product validations", productName, x.getName());
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
