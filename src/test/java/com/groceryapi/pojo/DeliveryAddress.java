package com.groceryapi.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddress {
	public String apartment;
    public Object lat;
    public Object lng;
    public String address;
    public String zipcode;
    public String city;
    public String state;
    public String country;

}
