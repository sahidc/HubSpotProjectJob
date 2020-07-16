package com.qa.HubSpot.PageTest;

import com.beust.testng.TestNG;
import com.qa.HubSport.ExtentReport.ExtentReporterNG;

public class RunnerClass1 {
    @SuppressWarnings("deprecation")
	public static TestNG testng;
	public static void main(String[] args) {
		testng=new  TestNG();
		ExtentReporterNG ext=new ExtentReporterNG();
		testng.setTestClasses(new Class[] {HomePageTest.class});
		testng.addListener(ext);
		testng.run();

	}

}
