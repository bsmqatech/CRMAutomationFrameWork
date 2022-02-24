package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage; 
	TestUtil testUtil;
	
	String sheetName = "Contacts";
	
	
	public ContactsPageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initilization();
		loginpage = new LoginPage();
	//	testUtil = new TestUtil();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickOnContactsLink();
	}
	
	
	@Test (priority = 1)
	public void verifyContactsPagelabel() throws InterruptedException {
		Assert.assertTrue(contactsPage.verifyContactsPageLabel(), "WorkSpaceLabel Missing on the Page");
	}
	
	
	@Test (priority = 2)
	public void verifyContacts() {
		contactsPage.selectContacts("Jason John");
	}
	

	@Test (priority = 3)
	public void verifyMultiContacts() {
		contactsPage.selectContacts("Pradeep Kumar");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname, String middlename, String company) throws Exception {
		contactsPage.contactCreation();
		//contactsPage.createNewContact("Tom", "Peter", "Re", "Amazon.com");
		contactsPage.createNewContact(firstname, lastname, middlename, company);
	}
	
	
	  @AfterMethod
	  public void tearDown() { 
		  driver.quit(); 
		  }
	
	
	

}
