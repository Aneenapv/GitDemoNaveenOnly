package com.naveenlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenlabs.TestBase.TestBase;

public class MyAccountInformationPage extends TestBase {
	
	public MyAccountInformationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement editAccountFirstname;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clickOnContinueButtonEditAccount;
	
	
	public void editAccountFirstname()
	{
		editAccountFirstname.clear();
		editAccountFirstname.sendKeys("Jessy");
	}
	
	public void clickOnContinueButtonEditAccount()
	{
		clickOnContinueButtonEditAccount.click();
	}
	
	public MyAccountPage EditAccount()
	{
		editAccountFirstname();
		clickOnContinueButtonEditAccount();
		return new MyAccountPage();
	}

}
