package com.apiclass.pojoaddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addUserAdress_Input_Pojo {
	
	
	    private String first_name;
	    private String last_name;
	    private String mobile;
	    private String apartment;
	    private int state;
	    private int city;
	    private int country;
	    private String zipcode;
	    private String address;
	    private String address_type;
	    
	    
	}


