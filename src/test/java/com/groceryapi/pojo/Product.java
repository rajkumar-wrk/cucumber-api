package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	public String image;
    public String type;
    public String text;
    public int id;
    public int category_id;

}
