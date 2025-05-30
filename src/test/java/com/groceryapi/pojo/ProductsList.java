package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsList {
	
	 public int id;
	    public String image;
	    public String medium_image;
	    public String name;
	    public String price;
	    public String start_date;
	    public String end_date;
	    public int scheduled;
	    public String special_price;

}
