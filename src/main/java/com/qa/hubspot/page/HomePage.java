package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1.dashboard-selector__title");
	By createDashboardBtn = By.id("add-report");
	By accName =By.cssSelector("span.account-name");
	By dropArrow = By.xpath(")//img[@class=' nav-avatar ']");
	
	//By menuClick =  By.className("menu");
	By mainContactsClick = By.id("nav-primary-contacts-branch");
	By childContactsClick = By.id("nav-secondary-contacts");
	
	By salesClick = By.linkText("Sales");
	By dealsClick= By.linkText("Deals");
	
	public HomePage(WebDriver driver){
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		return elementUtil.doGetPageTitle();
	}
	
	public String getPageHeader(){
		return elementUtil.getElement(header).getText();
	}
	
	public boolean checkDashboardBtn(){
		return elementUtil.doIsDisplyed(createDashboardBtn);
	}
	
	public String checkAccName(){
		elementUtil.doClick(dropArrow);
		return elementUtil.doGetText(accName);
	}
	
	public ContactsPage checkContactsPageLand(){
	//	elementUtil.doClick(menuClick);
		elementUtil.doClick(mainContactsClick);
		elementUtil.doClick(childContactsClick);
		return new ContactsPage(driver);
	}
		
	public void checkDealsPageLand(){
		elementUtil.doClick(salesClick);
		elementUtil.doClick(dealsClick);
		//return new DealsPage();
	
	}

	
	
	

}
