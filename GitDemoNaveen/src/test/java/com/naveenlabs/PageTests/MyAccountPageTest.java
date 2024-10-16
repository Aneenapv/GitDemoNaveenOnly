package com.naveenlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenlabs.Pages.AccountLoginPage;
import com.naveenlabs.Pages.MyAccountInformationPage;
import com.naveenlabs.Pages.MyAccountPage;
import com.naveenlabs.TestBase.TestBase;

public class MyAccountPageTest extends TestBase {
	
	
	AccountLoginPage login;
	MyAccountPage myAccountPage;
	MyAccountInformationPage myAccountInformationPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		login = new AccountLoginPage();
	}

	
	
	@Test
	public void EditAccount()
	{
		myAccountPage = login.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String MyAccountHeading = myAccountPage.getMyAccountHeading();
		Assert.assertEquals("My Account",MyAccountHeading);
		Assert.assertEquals("My Account", driver.getTitle());
		
		myAccountInformationPage = myAccountPage.clickOnEditAccount();
		myAccountPage= myAccountInformationPage.EditAccount();
		
		String alertEditAccountSuccessfulText = myAccountPage.alertEditAccountSuccessful();
		Assert.assertEquals("Success: Your account has been successfully updated.",alertEditAccountSuccessfulText);
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	
}
