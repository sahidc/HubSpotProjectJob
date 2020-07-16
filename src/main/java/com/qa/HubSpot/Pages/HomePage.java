package com.qa.HubSpot.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.HubSpot.Base.TestBase;

public class HomePage extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	ConversationPage conversationpage;
	SalesPage  salespage;
	DealsPage   dealpage;
	@FindBy(xpath="//img[@class=' nav-avatar ']")
	WebElement ACC_ID;
	
	@FindBy(xpath="//a[@class='uiButton private-button private-button--primary private-button--default private-button--non-link']")
	WebElement Restart_Demo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactPage clickOnContactPage() {
		 List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a"));
         try { for(int i=0;i<lst.size();i++) {
          	System.out.println(lst.get(i).getText());
          	if(lst.get(i).getText().equals("Contacts")) {
          		lst.get(i).click();
          	}   } }
          		catch(StaleElementReferenceException e) 
          		{
          			lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a"));
          		}

	     
        return new ContactPage();
	}

   
	public SalesPage clickOnSalesPage() {
		  List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a"));
	         for(int i=0;i<lst.size();i++) {
	         	System.out.println(lst.get(i).getText());
	         	if(lst.get(i).getText().equals("Sales")) {
	         		lst.get(i).click();
	         	}
	         } 
	       try {  List<WebElement> lst1=driver.findElements(By.xpath("//ul[@role='none']//li//a//div"));
	         for(int j=0;j<lst1.size();j++) {
	         	System.out.println(lst1.get(j).getText());
	         	if(lst1.get(j).getText().equals("Tasks")) {
	         		lst1.get(j).click();
	         	}
	         }
	         }
	   catch(StaleElementReferenceException e) {
		   lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a")); 
	       }
		
		return new SalesPage();
	}
	public DealsPage clickOnDealsPage() {
		  List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a"));
	         for(int i=0;i<lst.size();i++) {
	         	System.out.println(lst.get(i).getText());
	         	if(lst.get(i).getText().equals("Sales")) {
	         		lst.get(i).click();
	         	}
	         } 
	       try {  List<WebElement> lst1=driver.findElements(By.xpath("//ul[@role='none']//li//a//div"));
	         for(int j=0;j<lst1.size();j++) {
	         	System.out.println(lst1.get(j).getText());
	         	if(lst1.get(j).getText().equals("Deals")) {
	         		lst1.get(j).click();
	         	}
	         }
	
	         }
	   catch(StaleElementReferenceException e) {
		   lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a")); 
	       }
		
		return new DealsPage();
	}
  
	public ConversationPage clickOnConversationPage() {
		 List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a"));
         for(int i=0;i<lst.size();i++) {
         	System.out.println(lst.get(i).getText());
         	if(lst.get(i).getText().equals("Conversations")) {
         		lst.get(i).click();
         	}
         } 
        try { List<WebElement> lst1=driver.findElements(By.xpath("//ul[@role='none']//li//a//div"));
         for(int j=0;j<lst1.size();j++) {
         	System.out.println(lst1.get(j).getText());
         	if(lst1.get(j).getText().equals("Inbox")) {
         		lst1.get(j).click();
         	}
         }
        }
        catch(StaleElementReferenceException e) {
        	lst=driver.findElements(By.xpath("//ul[@class='primary-links']//li//a"));
        }
		return new ConversationPage();
	}

  
	public String getHomePageTitle() {
	 
		return driver.getTitle();
 }
	public boolean isDisplayAccountID() {
		return ACC_ID.isDisplayed();
	}
}
