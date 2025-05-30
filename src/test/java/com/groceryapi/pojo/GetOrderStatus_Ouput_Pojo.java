package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderStatus_Ouput_Pojo {

	public int status;
    public String message;
    public String currency;
    public Ordr order;
    public ArrayList<Prodct> products;
    public boolean cancel_allowed;
    public boolean return_allowed;
}
