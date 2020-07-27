package com.qa.hubspot.page;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class DealsPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	public DealsPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		}
	
	
}
