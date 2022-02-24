package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsPageLogo;
	
	@FindBy (xpath = "//button[text()='Create']")
	WebElement createContact;
	
	@FindBy (name = "first_name")
	WebElement firstName;
	
	@FindBy (name = "last_name")
	WebElement lastName;
	
	@FindBy (name = "middle_name")
	WebElement middleName;
	
	@FindBy (xpath = "//div/label[text()='Company']/following-sibling::div/input[@type='text']")
	WebElement companyName;
	
	@FindBy (xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	
//	@FindBy(xpath = "//div/div/div/div/span[text()='Salesforce permissions bug']")
//	WebElement selectTheTask;
	

	public ContactsPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel() throws InterruptedException {
		Thread.sleep(4000);
		return contactsPageLogo.isDisplayed();
	}
	
	
	public void selectContacts(String name) {
		//driver.findElement(By.xpath("//div/div/div/div/span[text()='"+name+"']")).click();
		driver.findElement(By.xpath("//td/a[text()='"+name+"']//..//..//td/div[@class='ui fitted read-only checkbox']"));
	}
	
	
	public void contactCreation() throws Exception {
		Thread.sleep(5000);
		boolean display = createContact.isDisplayed();
		System.out.println("Create contact Button Display : " + display);
		createContact.click();
	}
	
	public void createNewContact(String ftName,String ltName,String midName,String compName) throws Exception {
		Thread.sleep(5000);
		firstName.sendKeys(ftName);
		Thread.sleep(3000);
		lastName.sendKeys(ltName);
		Thread.sleep(3000);
		middleName.sendKeys(midName);
		Thread.sleep(3000);
		companyName.sendKeys(compName);
		Thread.sleep(3000);
		boolean display =saveBtn.isDisplayed();
		System.out.println("Save button display : " + display);
		saveBtn.click();
		Thread.sleep(10000);
	}
	
}
