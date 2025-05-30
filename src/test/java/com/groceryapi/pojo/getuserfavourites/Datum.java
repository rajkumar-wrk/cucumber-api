package com.groceryapi.pojo.getuserfavourites;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datum {

	   public int id;
	    public String product_code;
	    public String image;
	    public String name;
	    public String description;
	    public String manage_stock;
	    public String quick_grab;
	    public String is_exclusive;
	    public String status;
	    public String medium_image;
	    public int cart_count;
	    public ArrayList<Variation> variations;
	    public String price;
	    public String special_price;
	    public String original_special_price;
	    public int discount;
	    public ArrayList<Integer> product_variation_option;
	    public int product_variation_id;
	    public int is_favorite;
}
