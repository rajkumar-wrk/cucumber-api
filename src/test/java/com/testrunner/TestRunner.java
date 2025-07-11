package com.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(tags="@Login",dryRun = false, glue = "com.stepdefinations", features = "src\\test\\resources\\Features", plugin = {
		"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class TestRunner {

//	@AfterClass
//	public static void afterClass() {
//		Reporting.jvmReport(new File(System.getProperty("user.dir")) + "\\\\target\\\\jsonReports\\\\api.json");
//
//	}

	
}
