package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.ContactsPage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	Credentials userCred;

	@BeforeTest
	public void setup() throws InterruptedException{
		 basePage = new BasePage();
		 prop = basePage.init_prop();
		 driver = basePage.init_driver(prop);
		 driver.get(prop.getProperty("url"));
		 loginPage = new LoginPage(driver);
		 userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		 homePage = loginPage.doLogin(userCred);
		 Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() throws InterruptedException{
		Thread.sleep(5000);
		String title = homePage.getHomePageTitle();
		System.out.println("HomePageTitle is : "+title);
		Assert.assertEquals(title, "Reports dashboard");
	}
	
	@Test(priority=2)
	public void verifyHomePageHeader(){
		String header = homePage.getPageHeader();
		System.out.println("HomePageHeader is : "+header);
		Assert.assertEquals(header, "Sales Dashboard");
	}
		
	@Test(priority=3)
	public void verifyCreateDashboardBtn(){
		Assert.assertTrue(homePage.checkDashboardBtn());
	}
	
	@Test(priority=4)
	public void verifyAccName(){
		String name = homePage.checkAccName();
		System.out.println("Account Name = "+name);
		Assert.assertEquals(name,"Tamsas");
	
	}
	
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
		
	}
	

