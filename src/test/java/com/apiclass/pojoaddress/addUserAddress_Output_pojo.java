package com.apiclass.pojoaddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addUserAddress_Output_pojo {
	 
	private int status;
	private String message;
	private int address_id;

}
