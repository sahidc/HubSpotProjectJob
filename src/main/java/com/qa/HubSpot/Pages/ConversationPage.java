package com.qa.HubSpot.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.HubSpot.Base.TestBase;

public class ConversationPage extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	DealsPage   dealpage;
	
	@FindBy(xpath="//span[contains(text(),'Inbox')]")
	WebElement InboxText;
	@FindBy(xpath="//img[@src='//static.hsappstatic.net/ui-images/static-2.350/optimized/conversations-inbox.svg']")
	WebElement Email_Link;
	@FindBy(xpath="//div[@id='bsb-5']")
	WebElement chat_Link;
    @FindBy(xpath="//img[@src='//static.hsappstatic.net/ui-images/static-2.350/optimized/forms.svg']")
    WebElement Form_Link;
    
    public ConversationPage() {
    	PageFactory.initElements(driver, this);
    }
    public String getTitle() {
    	return driver.getTitle();
    }
    public boolean getInboxText() {
    	return InboxText.isDisplayed();
    }
    public void clickOnEmailLink() {
    	Email_Link.click();
    }
	public void clickOnChatLink() {
		chat_Link.click();
	}
	public void clickOnFormLink() {
		Form_Link.isDisplayed();
	}
}
