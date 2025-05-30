package com.groceryapi.pojo.addtocart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCart_Output_Pojo {
	
	 public int status;
	    public String message;
	    public String currency;
	    public int cart_count;
	    public Datas data;

}
