package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	 LoginPage loginpage;
	 HomePage homePage;
	 TestUtil testUtil;
	 ContactsPage contactsPage;
	
	public HomePageTest() throws Exception {
		super();
	}



	@BeforeMethod
	public void setUp() throws Exception {
		initilization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		
		Thread.sleep(10000);
		String HomePageTitle = homePage.verifyHomePageTitle();
		System.out.println("**********" + HomePageTitle + "**********");
		
		Assert.assertEquals(HomePageTitle, "Cogmento CRM");
		
	}
	
	
	
	
	  @Test (priority = 2) 
	  public void userNameLabelTest() throws InterruptedException { 
	  Thread.sleep(10000); 
	  

	  System.out.println("********************************************************************");
	  boolean nameLabel = homePage.userNameValidation(); 
	  System.out.println("User name Label ::::>> " +nameLabel);
	  Assert.assertTrue(nameLabel); 

	
	  }
	  
	  
	  @Test (priority = 3)
	  public void contactsButtonLink() throws Exception {
		  contactsPage = homePage.clickOnContactsLink();
	  }
	 
	
	
	
	
	
	
	  @AfterMethod
	  public void tearDown() { 
		  driver.quit(); 
		  }
	 
	
	

}
