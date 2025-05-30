package com.apiclass.pojoaddress;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAddress_Output_pojo {
	public int status;
    public String message;
    public ArrayList<Datum> data;

}
