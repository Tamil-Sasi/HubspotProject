package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	//public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	//public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>(); 
	public WebDriver driver;
	
//	public static WebDriver getDriver(){
//		return tldriver.get();
//	}
	
	public WebDriver init_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		optionsManager = new OptionsManager(prop);
		if (browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
//			if(prop.getProperty("headless").equals("yes")){
//				ChromeOptions co = new ChromeOptions();
//				co.addArguments("--headless");
//				driver = new ChromeDriver(co);
//			}
//			else{
//			driver = new ChromeDriver();
//			}
		} 
		else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
//			if(prop.getProperty("headless").equals("yes")){
//				FirefoxOptions fo = new FirefoxOptions();
//				fo.addArguments("--headless");
//				driver = new FirefoxDriver(fo);
//			}
//			driver = new FirefoxDriver();
		} 
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver(); 
		}
		else {
			System.out.println("Please check and provide the right browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get(url);
	return driver;
	}
	
	public Properties init_prop(){
		
	 prop = new Properties();
	 String path = "./src/main/java/com/qa/hubspot/config/config.properties";
	 try {
		FileInputStream ip = new FileInputStream(path);
		prop.load(ip);
	} catch (FileNotFoundException e) {
		System.out.println("Path not found..please correct your config");
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;	
		
}
}


