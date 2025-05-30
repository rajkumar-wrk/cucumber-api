package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeOptions {
	 public int id;
	    public int attribute_id;
	    public String value;
	    public String status;
	    public String created_at;
	    public String updated_at;

}
