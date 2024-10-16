package com.naveenlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenlabs.Pages.AccountLoginPage;
import com.naveenlabs.Pages.AddressBookPage;
import com.naveenlabs.Pages.ForgotYourPasswordPage;
import com.naveenlabs.Pages.MyAccountPage;
import com.naveenlabs.TestBase.TestBase;

public class AddressBookPageTest extends TestBase {
	
	AccountLoginPage login;
	ForgotYourPasswordPage forgotPassword;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;

	@BeforeMethod
	public void setup()
	{
		initialise();
		login = new AccountLoginPage();
	}
	
	
	@Test
	public void ValidateDefaultAddressBookDelete()
	{
		myAccountPage = login.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String MyAccountHeading = myAccountPage.getMyAccountHeading();
		Assert.assertEquals("My Account",MyAccountHeading);
		Assert.assertEquals("My Account", driver.getTitle());
		
		addressBookPage = myAccountPage.clickOnAddressBook();
		addressBookPage.addressDefautDeleteButton();
		driver.switchTo().alert().accept();
		String alertAddressBookText = addressBookPage.getAlertAddressBook();
		Assert.assertEquals("Warning: You can not delete your default address!",alertAddressBookText);
		
	}
	
	
	@Test
	public void ValidateAddressBookNewAddress()
	{
		myAccountPage = login.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String MyAccountHeading = myAccountPage.getMyAccountHeading();
		Assert.assertEquals("My Account",MyAccountHeading);
		Assert.assertEquals("My Account", driver.getTitle());
		
		addressBookPage = myAccountPage.clickOnAddressBook();
		addressBookPage = addressBookPage.addNewAddress();
		String AlertMessageNewAddressAddedSuccessfullyText = addressBookPage.getAlertMessageNewAddressAddedSuccessfully();
		Assert.assertEquals("Your address has been successfully added", AlertMessageNewAddressAddedSuccessfullyText);
		
	}
	
	
	@Test
	public void ValidateAddedAddressBookDelete()
	{
		myAccountPage = login.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String MyAccountHeading = myAccountPage.getMyAccountHeading();
		Assert.assertEquals("My Account",MyAccountHeading);
		Assert.assertEquals("My Account", driver.getTitle());
		
		addressBookPage = myAccountPage.clickOnAddressBook();
		addressBookPage.addressAddedDeleteButton();
		driver.switchTo().alert().accept();
		String alertAddressBookText = addressBookPage.getAlertAddressBook();
		Assert.assertEquals("Your address has been successfully deleted",alertAddressBookText);
		
	}
	
	
	@Test
	public void ValidateEditAddressBookDelete()
	{
		myAccountPage = login.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String MyAccountHeading = myAccountPage.getMyAccountHeading();
		Assert.assertEquals("My Account",MyAccountHeading);
		Assert.assertEquals("My Account", driver.getTitle());
		
		addressBookPage = myAccountPage.clickOnAddressBook();
		addressBookPage.editAddressBook();
		
		String alertAddressBookText = addressBookPage.getAlertAddressBook();
		Assert.assertEquals(alertAddressBookText,"Your address has been successfully updated");
		
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	
	

}
