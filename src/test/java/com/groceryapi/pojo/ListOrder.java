package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOrder {
	public int order_id;
    public String order_no;
    public String delivery_time;
    public DeliveryAddress delivery_address;
    public String current_date;
    public String scheduled;
    public String status;
}


