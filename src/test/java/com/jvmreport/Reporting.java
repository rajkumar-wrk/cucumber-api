package com.jvmreport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



public class Reporting {
	
	public static void jvmReport(String json) {
		File file=new File(System.getProperty("user.dir")+"\\target\\jvmReports");
		
		
		Configuration configuration=new Configuration(file,"Api");
		
		List<String>list=new ArrayList<String>();
		list.add(json);
		
		ReportBuilder builder=new ReportBuilder(list, configuration);
		builder.generateReports();
		
		

	}

}
