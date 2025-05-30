package com.groceryapi.pojo.getuserfavourites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeOption {
	
	 public int id;
	    public int attribute_id;
	    public String value;
	    public String status;
	    public String created_at;
	    public String updated_at;

}
