package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderDetails_Output_Pojo {
	public int status;
    public String message;
    public String currency;
    public Datas data;
    public ArrayList<Calendar> calendar;
    public String current_date;
    public ArrayList<Prodcts> products;

}
