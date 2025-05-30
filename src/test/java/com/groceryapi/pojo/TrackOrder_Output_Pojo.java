package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackOrder_Output_Pojo {
	 public int status;
	    public String message;
	    public ArrayList<OrderStatus> order_status;
	    public ListOrder order;

}