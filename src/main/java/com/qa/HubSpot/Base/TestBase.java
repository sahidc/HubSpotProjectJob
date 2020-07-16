package com.qa.HubSpot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.HubSpot.Util.TestUtil;
import com.qa.SalesForce.Util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Mashuda\\eclipse-workspace\\SeleniumProject"
					+ "\\HubSpotPOM\\src\\main\\java\\com\\qa\\HubSpot\\Config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization() {
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();}
	        else if(browser.equals("Firefox")){
	        	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	            driver=new FirefoxDriver();
	        }
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Load_Time, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
	}


