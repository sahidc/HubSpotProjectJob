package com.qa.HubSpot.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.HubSpot.Base.TestBase;

public class ContactPage extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	@FindBy(xpath="//h1[@class='IndexPageRedesignHeader__StyledH1-ljkrr-1 dTXiYC']//i18n-string[contains(text(),'Contact')]")
	WebElement ContactLogo;
	
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
	WebElement Create_Contact;
	
	@FindBy(xpath="//input[@data-field='email']")
	public static WebElement User_ID;
	
	@FindBy(xpath="//input[@data-field='firstname']")
	public static WebElement FirstName;
	
	@FindBy(xpath="//input[@data-field='lastname']")
	public static WebElement LastName;
	
	@FindBy(xpath="//input[@data-field='jobtitle']")
	public static WebElement JobTitle;
	
	
	@FindBy(xpath="//input[@data-field='phone']")
	public static WebElement PhoneNumber;
	
	@FindBy(xpath="//li//span[text()='Create contact']")
	public static WebElement Create_Contact_BTN;
	
	public ContactPage() {
		PageFactory.initElements(driver,this);
	}
	 
	public boolean isDisplayedContactLogo() {
		return ContactLogo.isDisplayed();
	}
	public String getTitleContactPage() {
		return driver.getTitle();
	}
	
	public void CreateContact() {
		Create_Contact.click();
	}
	
	
}
