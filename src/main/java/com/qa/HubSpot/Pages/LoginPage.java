package com.qa.HubSpot.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.HubSpot.Base.TestBase;

public class LoginPage extends TestBase{
	HomePage homePage;
	@FindBy(xpath="//input[@id='username']")
	WebElement userid;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginBtn;
	
	
	@FindBy(xpath="//div[@class='auth-box marketing-box']")
	WebElement HubSpotLogo;
	
	@FindBy(xpath = "//a/i18n-string[text()='Forgot my password']")
	WebElement forgotPwdLink;
	public  LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public HomePage login(String uid,String pwd )
	{
		userid.sendKeys(uid);
		password.sendKeys(pwd);
		LoginBtn.click();
		System.out.println("login is done");
		return homePage=new HomePage();
		
	}
	 public boolean HubSoptLogo() {
		return  HubSpotLogo.isDisplayed();
	
	 }
	 public String HubSpotTitle() {
		 return driver.getTitle();
	 }
	public boolean isDisplayedForgetPassword() {
		return forgotPwdLink.isDisplayed();
	}
}
