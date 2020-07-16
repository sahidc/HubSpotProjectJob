package com.qa.HubSpot.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.HubSpot.Base.TestBase;
import com.qa.HubSpot.Pages.ContactPage;
import com.qa.HubSpot.Pages.ConversationPage;
import com.qa.HubSpot.Pages.DealsPage;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Pages.SalesPage;

public class ConversationPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	DealsPage   dealpage;
	
	public ConversationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		conversationpage=homePage.clickOnConversationPage();
	}
	
	@Test(priority=1)
	public void getInboxTextTest() {
		boolean flag=conversationpage.getInboxText();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void getTitleText() {
		
		String title=conversationpage.getTitle();
		Assert.assertEquals(title, "Inbox");
	}
	@Test(priority=3)
	public  void clickOnEmailLinkText() {
		conversationpage.clickOnEmailLink();
	}
	@Test(priority=4)
	public void clickOnChatLinkText() {
		conversationpage.clickOnChatLink();
	}
	@Test(priority=5)
	public void clickOnFormLinkText() {
		conversationpage.clickOnFormLink();
	}
}
