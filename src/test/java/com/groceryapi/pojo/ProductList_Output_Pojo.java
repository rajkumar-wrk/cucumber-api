package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList_Output_Pojo {
	
	 public int status;
	    public String message;
	    public String currency;
	    public ArrayList<Products> data;
	    public String banner;
	    public int cart_count;

}
