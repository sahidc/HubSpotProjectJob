package com.qa.HubSpot.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.HubSpot.Base.TestBase;

public class SalesPage extends TestBase {
	@FindBy(xpath="//h1[@class='IndexPageRedesignHeader__StyledH1-ljkrr-1 dTXiYC']//i18n-string[contains(text(),'Deals')]")
    WebElement DealText;
	
	
	@FindBy(xpath="//span[contains(text(),'Create deal')]")
	WebElement CreateDeal;
	
	@FindBy(xpath="//input[@data-field='dealname']")
	public static WebElement DealName;
	
	@FindBy(xpath="//input[@data-field='dealname']")
	public static WebElement DealAmount;
	
	@FindBy(xpath="//span[contains(text(),'Create') and @class='private-loading-button__content private-button--internal-spacing']")
	public static WebElement createDealBTN;
	 
	public SalesPage() {
		PageFactory.initElements(driver, this);
	}
	public String getSalesPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isDispalyedDealText() {
		return DealText.isDisplayed();
	}
	
	public void createDeals() {
		CreateDeal.click();
	}
}
