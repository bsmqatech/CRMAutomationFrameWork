package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	//page factory "or" Object repository
	@FindBy(xpath = "//div/b[contains (text(),'BSM Tech')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsButton;
	
	
	//Initializing the page objects
	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() throws Exception {
		contactsButton.click();
		return new ContactsPage();
	}
	
	public boolean userNameValidation() {
		return userNameLabel.isDisplayed();
	}
	
	
	
}
