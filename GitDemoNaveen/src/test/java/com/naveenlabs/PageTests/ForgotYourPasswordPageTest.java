package com.naveenlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenlabs.Pages.AccountLoginPage;
import com.naveenlabs.Pages.ForgotYourPasswordPage;
import com.naveenlabs.TestBase.TestBase;

public class ForgotYourPasswordPageTest extends TestBase{
	
	
	AccountLoginPage login;
	ForgotYourPasswordPage forgotPassword;
	
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		login = new AccountLoginPage();
	}
	

	
	@Test
	public void ForgotPasswordFunctionalityWithInvalidEmail()
	{
		forgotPassword=login.clickOnForgottenPassword();
		
		forgotPassword.enterForgotEmailAddress("cent@gmail.com");
		forgotPassword.clickOnContinueButton();
	
		String alertConfirmation = forgotPassword.getalertBannerForInvalidEmailForgotPassword().trim();
		Assert.assertEquals("Warning: The E-Mail Address was not found in our records, please try again!", alertConfirmation);
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}

}
