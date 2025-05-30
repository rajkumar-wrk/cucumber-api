package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderItemStatus_Inout_Pojo {
	
	private String order_id;

	private String item_id;
	

	
}
