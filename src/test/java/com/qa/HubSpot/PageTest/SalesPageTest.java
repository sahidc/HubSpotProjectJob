package com.qa.HubSpot.PageTest;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HubSpot.Base.TestBase;
import com.qa.HubSpot.Pages.ContactPage;
import com.qa.HubSpot.Pages.ConversationPage;
import com.qa.HubSpot.Pages.DealsPage;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Pages.SalesPage;
import com.qa.HubSpot.Util.TestUtil1;

public class SalesPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	DealsPage   dealpage;
	public SalesPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	   	  loginPage=new LoginPage();
	   	  homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	   	  dealpage=homePage.clickOnDealsPage();
	   	  Thread.sleep(3000);
          }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
    @Test(priority=2)
    public void getSalesPageTitleTest() {
    	String title=dealpage.getDealPageTitle();
    	Assert.assertEquals(title, "Deals");
    }
    
    @Test(priority=1)
    public void isDispalyedDealTextTest() throws InterruptedException {
    	Thread.sleep(3000);
    	boolean flag=dealpage.isDispalyedDealText();
    	Assert.assertTrue(flag);
    }
    @DataProvider
 	public Iterator<Object[]>  myTestData1(){
 		ArrayList<Object[]> data=TestUtil1.getDataFromExcelSheet2();
 		return data.iterator();
 		}
    @Test(priority=3,dataProvider="myTestData1")
    public void CreateDealTest(String DealN,String DealA) {
    	dealpage.createDeals();
    	dealpage.DealName.sendKeys("DealN");
    	dealpage.DealAmount.sendKeys("DealA");
    	dealpage.createDealBTN.click();
    }
    
}
