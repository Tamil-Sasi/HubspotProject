package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.ContactsPage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {
	WebDriver driver;
	BasePage base;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;
	HomePage homePage;
	ContactsPage contactsPage;

	
	
	@BeforeMethod
	public void setUp(){
		base = new BasePage();
        prop = base.init_prop();
		driver = base.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"),prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
		contactsPage = homePage.checkContactsPageLand();
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitle() throws InterruptedException{
		Thread.sleep(5000);
		String title = contactsPage.getContactsPageTitle();
		System.out.println("ContactsPage title is : "+title);
		Assert.assertEquals(title, "Contacts");
	}
	
	@DataProvider
	public Object[][] getContactsTestData(){
		Object data[][] = ExcelUtil.getExcelData("contacts");
				
	    return data;			
}
	
	@Test(priority=2, dataProvider="getContactsTestData")
	public void createContactTest(String email, String fn, String ln){
		contactsPage.doCreateContact(email,fn,ln);	 
		
	}
	
	@AfterMethod
	public void tearDown(){ 
		driver.quit();
	}

}
