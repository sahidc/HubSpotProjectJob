package com.qa.HubSpot.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.HubSpot.Base.TestBase;

public class TestUtil extends TestBase {
	public static long Page_Load_Time=20; 
	public static long Implicit_Load_Time=20; 
	public static String LoginPageTitle="HubSpot Login"; 
	public static String HomePageTitle="HubSpot | Redirecting...";
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	}

