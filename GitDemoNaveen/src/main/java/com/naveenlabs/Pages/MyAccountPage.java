package com.naveenlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenlabs.TestBase.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="div.col-sm-9 h2:first-of-type")
	WebElement myAccountHeading;
	
	@FindBy(css="div.list-group a:nth-of-type(2)")
	WebElement clickOnEditAccount;
	
	@FindBy(css="div.alert")
	WebElement alertEditAccountSuccessful;
	
	@FindBy(css="div.list-group a:nth-of-type(4)")
	WebElement clickOnAddressBook;
	
	public String getMyAccountHeading()
	{
		return myAccountHeading.getText().trim();
	}
	
	public MyAccountInformationPage clickOnEditAccount()
	{
		clickOnEditAccount.click();
		return new MyAccountInformationPage();
	}
	
	public String alertEditAccountSuccessful()
	{
		return alertEditAccountSuccessful.getText().trim();
	}
	
	public AddressBookPage clickOnAddressBook()
	{
		clickOnAddressBook.click();
		return new AddressBookPage();
		
	}
	

}
