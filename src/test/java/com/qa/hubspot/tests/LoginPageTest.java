package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;

public class LoginPageTest {
	WebDriver driver;
	BasePage base;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;
	
	@BeforeTest
	public void setup(){
		base = new BasePage();
		prop = base.init_prop();
		driver = base.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyPageTitle() throws InterruptedException{
		Thread.sleep(5000);
		String title = loginPage.getPageTitle();
		System.out.println("Page Title "+title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void verifySignUpLink(){
		Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	
	
	@Test(priority=3)
	public void loginTest(){
		HomePage homePage =loginPage.doLogin(userCred);
		String text = homePage.getPageHeader();
		Assert.assertEquals(text, "Sales Dashboard");
	}
	
	
	
	@DataProvider
	public Object[][] getInvalidData(){
		Object data[][] = { 
				          {"test121@gmail.com" , "test123"},
		                  {"test@gmail.com"," "},
				          {" " , "test123"},
				          {"testt1" ,"test123"},
				          {" ", " "} };
		return data;
	}
	
	@Test(priority=4 ,dataProvider ="getInvalidData", enabled = false)
	public void invalidLoginTest(String username, String pwd){
        userCred.setAppUserName(username);
		userCred.setPassword(pwd);
		loginPage.doLogin(userCred);
		//Assert.assertTrue(loginPage.loginErrorText());
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	

}
