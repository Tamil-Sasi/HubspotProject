package com.qa.hubspot.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Credentials;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	Credentials userCred;
	
	//Locators
	
	By emailid = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By showPwdLink = By.xpath("//span[contains(text(),'Show Password')]");
	By rememberText = By.xpath("//i18n-string[contains(text(),'Remember me')]");
	By checkSignUpPage = By.cssSelector("h4.m-bottom-2");
    By errorText = By.xpath("//div[@class='private-alert__inner']");
    
    
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
				
	}
	
	public String getPageTitle(){
		return elementUtil.doGetPageTitle();
	}
	
	public boolean checkSignUpLink(){
		return elementUtil.doIsDisplyed(signUpLink);
	}
	
	public boolean checkShowPwdLink(){
		return elementUtil.doIsDisplyed(showPwdLink);
	}
	
	public String checkRememberMeText(){
		return elementUtil.doGetText(rememberText);
	}
	
	public boolean checkSignupPage(){
		return elementUtil.doIsDisplyed(checkSignUpPage);
		
	}
	
	public HomePage doLogin(Credentials userCred){
		elementUtil.doSendKeys(emailid, userCred.getAppUserName());
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		elementUtil.doClick(login);
		return new HomePage(driver);
	}
	
	public boolean loginErrorText(){
		return elementUtil.doIsDisplyed(errorText);
	}
}
