package com.qa.HubSpot.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.HubSpot.Base.TestBase;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
		}
    @BeforeTest
    public void SetUp() {
    	initialization();
    	loginPage=new LoginPage();  	
    }
    @AfterTest
    public void TearDown()
    {
    	driver.quit();
    }
    @Test(priority=4)
    public void LoginTest() {
    	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	
    }
    @Test(priority=2)
    public void TitleTest() {
    	String title=loginPage.HubSpotTitle();
    	Assert.assertEquals(title, TestUtil.LoginPageTitle);
    }
    @Test(priority=3)
    public void HubSoptLogoTest() {
    	boolean flag=loginPage.HubSoptLogo();
    	Assert.assertTrue(flag);
    }
    @Test(priority=1)
    public void isDisplayedForgetPasswordTest() {
    	boolean flag=loginPage.isDisplayedForgetPassword();
    	Assert.assertTrue(flag);
    }
}
