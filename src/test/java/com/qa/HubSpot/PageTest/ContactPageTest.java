package com.qa.HubSpot.PageTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HubSpot.Base.TestBase;
import com.qa.HubSpot.Pages.ContactPage;
import com.qa.HubSpot.Pages.ConversationPage;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Pages.SalesPage;
import com.qa.HubSpot.Util.TestUtil1;


public class ContactPageTest extends TestBase{
	public WebDriver driver;
	Logger log=Logger.getLogger(ContactPageTest.class);
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage=homePage.clickOnContactPage();
		log.info("Move to Contact Page");
		
	}
	@AfterMethod
	   public void tearDown() {
		driver.quit();
	    }
	@Test(priority=1)
	public void getTitleContactPageTest() {
		String title=contactpage.getTitleContactPage();
		Assert.assertEquals(title, "Contacts");
		log.info("Title Matched");
	}
	@Test(priority=2)
	public void isDisplayedContactLogoTest() {
		boolean flag=contactpage.isDisplayedContactLogo();
		Assert.assertTrue(flag);
		log.info("Displayed");
	}
	
	@DataProvider
 	public Iterator<Object[]>  myTestData1(){
 		ArrayList<Object[]> data=TestUtil1.getDataFromExcel();
 		return data.iterator();
 		}
 	@Test(priority=3,dataProvider="myTestData1")
 	 public void CreateContactTest(String uesrid1,String FirstName1, String LastName1, String JobTitle1, String PhoneNumber1)throws InterruptedException {
 		 contactpage.CreateContact();
 		 ContactPage.User_ID.sendKeys(uesrid1);
 		 ContactPage.FirstName.sendKeys(FirstName1);
 		 ContactPage.LastName.sendKeys(LastName1);
 		 ContactPage.JobTitle.sendKeys(JobTitle1);
 		 ContactPage.PhoneNumber.sendKeys(PhoneNumber1);
 		 ContactPage.Create_Contact_BTN.click();
 		
 		
 		
 				 
 	  }
}