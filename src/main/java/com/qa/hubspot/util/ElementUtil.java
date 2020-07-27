package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtil {
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver= driver;
	}
	
	
	
	public String doGetPageTitle(){
		try{
			return driver.getTitle();
		} catch(Exception e){
			System.out.println("Some exception occured while getting the page title");	
		}
		return null;
	}
	
	
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		} catch(Exception e){
			System.out.println("Some exception occured while creating the element");
		}
		return element;
	}
	
	public void doActionsClick(By locator){
		
		try{
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.click(element);
		}catch(Exception e){
			
		}
	}
	
	
	public void doClick(By locator){
		try{
			getElement(locator).click();	
		} catch(Exception e){
			
		}
	}
	
	public void doSendKeys(By locator,String value){
		try{
			WebElement ele = getElement(locator);
			 ele.clear();
			 ele.sendKeys(value);
		}catch(Exception e){
			System.out.println("Some exception occured while sending value to the web element");
		}
		 
	}
	
	public boolean doIsDisplyed(By locator){
		try{
			return getElement(locator).isDisplayed();
		}catch (Exception e){
			System.out.println("Some exception occured while clicking on the web element");		
		}
		return false;
		}
	
	public String doGetText(By locator){
		try{
		return getElement(locator).getText();
		}catch (Exception e){
			System.out.println("Some exception occured while getting the text from the web element");		
		}
		return null;
	}
		
}		
	


