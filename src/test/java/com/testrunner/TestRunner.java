package com.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.jvmreport.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( dryRun = false, glue="com.stepdefinations",features ="src\\test\\resources\\Features",plugin = {"pretty","json:E:\\class\\maven\\Api_Cucumber\\target\\jsonReports\\api.json"})
public class TestRunner {
	
	
	@AfterClass
	public static void afterClass() {
		Reporting.jvmReport(new File(System.getProperty("user.dir"))+"\\\\target\\\\jsonReports\\\\api.json");

	}
	

}













