package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory "or" Object repository
	@FindBy(xpath = "//input[@type='text' and @name='email']")
	WebElement username;
	
	@FindBy (xpath = "//input[@type='password' and @name='password']")
	WebElement password;
	
	@FindBy (xpath = "//div[text()='Login']")
	WebElement loginBtn;
	
//	@FindBy(xpath = "//img[@class='account-logo' and @alt='Monday logo']")
//	WebElement logo;
	
	
	//Initializing the page objects
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
//	public boolean validateLogo() {
//		return logo.isDisplayed();
//	}
	
	public HomePage login (String un, String pwd) throws Exception {
		
		Thread.sleep(6000);
		username.clear();
		Thread.sleep(6000);
		password.clear();
		Thread.sleep(6000);
		username.sendKeys(un);
		Thread.sleep(6000);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
}
