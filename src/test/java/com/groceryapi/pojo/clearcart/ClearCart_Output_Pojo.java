package com.groceryapi.pojo.clearcart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClearCart_Output_Pojo {
	public int status;
	public String message;
	public int cart_count;

}
