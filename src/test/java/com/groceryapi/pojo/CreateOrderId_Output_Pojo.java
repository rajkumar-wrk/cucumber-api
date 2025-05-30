package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderId_Output_Pojo {
	
	public int status;
    public String message;
    public String currency;
    public Order data;
    public int order_id;

}
