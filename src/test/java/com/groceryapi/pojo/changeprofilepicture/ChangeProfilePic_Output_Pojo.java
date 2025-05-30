package com.groceryapi.pojo.changeprofilepicture;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProfilePic_Output_Pojo {
	
	public int status;
    public String message;
    public Datas data;
    public int cart_count;

}
