package com.naveenlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenlabs.TestBase.TestBase;

public class ForgotYourPasswordPage extends TestBase{
	
	public ForgotYourPasswordPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	WebElement forgotEmailAddress; 
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(css="div.alert")
	WebElement alertBannerForInvalidEmailForgotPassword;
	
	
	
	 public void enterForgotEmailAddress(String email)
	 {
		 forgotEmailAddress.sendKeys(email); 
	 }
	 
	 public void clickOnContinueButton()
	 {
		 continueButton.click(); 
	 }
	 
	 public AccountLoginPage submitForgotPasswordRequest(String email)
	 {
		 enterForgotEmailAddress(email);
		 clickOnContinueButton();
		 return new AccountLoginPage();
	 }
	 
	 public String getalertBannerForInvalidEmailForgotPassword()
	 {
		 return alertBannerForInvalidEmailForgotPassword.getText();
	 }
	 
	
}
