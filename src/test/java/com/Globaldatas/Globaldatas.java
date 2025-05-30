package com.Globaldatas;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Globaldatas {
	private Response response;
	private String logToken;

	private String stateId;

	private String cityId;

	private String addressId;

	private String categoryId;
	
	private String productId;
	
	private String varientId;
	
	private String CartId;
	
	private String orderId;
	
	private String orderNo;

}
