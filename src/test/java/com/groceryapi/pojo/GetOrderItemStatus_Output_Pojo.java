package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderItemStatus_Output_Pojo {
	
	 public int status;
	    public String message;
	    public String currency;
	    public ProductsList products;
	    public ArrayList<Schedule> schedules;
	    public Odr order;

}
