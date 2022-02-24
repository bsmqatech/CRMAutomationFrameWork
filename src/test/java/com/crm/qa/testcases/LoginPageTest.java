package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	
	
	public LoginPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initilization();
		loginpage = new LoginPage();
	}
	
	
	@Test (priority = 1)
	public void loginPageTitleTest() {
		
		String title = loginpage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
//	@Test (priority = 2)
//	public void logoImageTest() {
//		boolean logo = loginpage.validateLogo();
//		Assert.assertTrue(logo);
//	}
	
	@Test (priority = 2)
	public void loginTest() throws Exception {
		homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	

}
