package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;
import com.qa.hubspot.util.JavaScriptUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	
	By createContact = By.xpath("//span[text()='Create contact']");
	By emailId = By.xpath("//input[@data-field='email']");
	By fstName = By.xpath("//input[@data-field='firstname']");
	By lstName = By.xpath("//input[@data-field='lastname']");
	By createCont = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");
	
	public ContactsPage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	
   public String getContactsPageTitle(){
	   return elementUtil.doGetPageTitle();
   }
  
   
   public boolean checkCreateContactText(){
	   return elementUtil.doIsDisplyed(createContact);
   }
   
   public void doCreateContact(String eid, String fn, String ln){
	   
	   elementUtil.doClick(createContact);
	   elementUtil.doSendKeys(emailId, eid);
	   elementUtil.doSendKeys(fstName, fn);
	   elementUtil.doSendKeys(lstName, ln);
	   jsUtil.clickElementByJS(elementUtil.getElement(createCont));
   }
   
   
}
