package com.naveenlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenlabs.TestBase.TestBase;

public class AccountLoginPage extends TestBase{
	
	public AccountLoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(css="#account-login div.alert")
	WebElement alertBanner;
	
	@FindBy(css="div.form-group a")
    WebElement forgottenPassword;
	
	@FindBy(css="div.alert")
	WebElement alertConfirmationForValidEmailForgotPaassword;
	
	
	private void enterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	private void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		 loginButton.click();
	}
	
	public String getAlertBannerTextVerify()
	{
		return alertBanner.getText();
	}
	

	public ForgotYourPasswordPage clickOnForgottenPassword()
	{
		forgottenPassword.click();
		return new ForgotYourPasswordPage();
	}
	
	public String getAlertConfirmationForEmailForgotPassword()
	{
		return alertConfirmationForValidEmailForgotPaassword.getText();
	}
	
	
	public MyAccountPage loginToMyAccount(String email,String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();
		return new MyAccountPage();
	}
	
}
