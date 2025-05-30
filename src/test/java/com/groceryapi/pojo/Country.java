package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

	 public int id;
	    public String code;
	    public String name;
	    public int phonecode;
	    public String currency_name;
	    public String currency_symbol;
	    public String currency_code;
	    public String status;
}
