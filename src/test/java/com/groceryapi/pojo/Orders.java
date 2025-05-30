package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	 public int id;
	    public String order_no;
	    public String amount;
	    public boolean wallet_show;
	    public String wallet_amount;
	    public String remaining_amount;
	    public String duration;
}
