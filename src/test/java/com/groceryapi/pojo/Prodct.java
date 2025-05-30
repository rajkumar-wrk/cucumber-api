package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prodct {

	 public int id;
	    public String image;
	    public String medium_image;
	    public String name;
	    public String price;
	    public String special_price;
}
