package com.groceryapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordr {
	public String amount;
    public boolean wallet_show;
    public String wallet_amount;
    public String remaining_amount;
    public String order_no;
    public int id;

}
