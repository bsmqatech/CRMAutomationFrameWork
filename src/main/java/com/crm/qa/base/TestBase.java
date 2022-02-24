package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	//Creation of constructor and initialize properties 
	public TestBase() throws Exception {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Multiple Programming Workspace\\Selenium\\FreeCRMTest2\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// create a method for initialization
	//@SuppressWarnings("deprecation")
	public static void initilization () throws Exception {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLECIT_TIMEOUT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	public static void implicitWait() {
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLECIT_TIMEOUT,TimeUnit.SECONDS);
	}

}
