package com.globallib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	
	public static String propertyReadValues(String key) throws IOException {
		
File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\Config.property");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		String values = properties.getProperty(key);
		
		System.out.println(key+" : "+properties.getProperty(key));
		return values;

	}

	public static void main(String[] args) throws IOException {
		
		String propertyReadValues = propertyReadValues("userName");
		
	}
}
