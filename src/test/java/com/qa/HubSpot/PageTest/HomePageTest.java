package com.qa.HubSpot.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.HubSpot.Base.TestBase;
import com.qa.HubSpot.Pages.ContactPage;
import com.qa.HubSpot.Pages.ConversationPage;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Pages.SalesPage;
import com.qa.HubSpot.Util.TestUtil;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
   @AfterMethod
   public void tearDown() {
	driver.quit();
    }
   
   @Test(priority=1)
   public void getHomePageTitleTest() {
	  String title= homePage.getHomePageTitle();
	  Assert.assertEquals(title,TestUtil.HomePageTitle);
   }
   @Test(priority=2)
   public void isDisplayAccountIDTest() {
	   boolean flag=homePage.isDisplayAccountID();
	   Assert.assertTrue(flag);
   }
   @Test(priority=3)
  public void clickOnContactPageTest() throws InterruptedException {
	   homePage.clickOnContactPage();
	   
   }
   @Test(priority=4)
   public void clickOnclickOnSalesPageTest() throws InterruptedException{
	   homePage.clickOnSalesPage();
	   

   }
   @Test(priority=5)
   public void clickOnConversationPageTest() throws InterruptedException{
	   homePage.clickOnConversationPage();
	   
   }
   @Test(priority=6)
   public void clickOnDealsPageTest() throws InterruptedException{
	   homePage.clickOnDealsPage(); 
	   
	   
   }
}