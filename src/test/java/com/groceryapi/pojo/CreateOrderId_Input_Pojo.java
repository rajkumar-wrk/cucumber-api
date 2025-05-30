package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderId_Input_Pojo {
	
	public String payment_method;
    public String card_no;
    public String card_type;
    public String year;
    public String month;
    public String cvv;

}
