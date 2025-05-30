package com.apiclass.pojoaddress;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateList_Output_Pojo {
	
	 public int status;
	    public String message;
	    public ArrayList<StateList> data;

}
