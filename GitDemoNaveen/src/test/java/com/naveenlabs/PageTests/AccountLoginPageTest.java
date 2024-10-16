package com.naveenlabs.PageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.naveenlabs.Pages.AccountLoginPage;
import com.naveenlabs.Pages.ForgotYourPasswordPage;
import com.naveenlabs.Pages.MyAccountPage;
import com.naveenlabs.TestBase.TestBase;
import com.naveenlabs.Utils.ExcelUtils;

public class AccountLoginPageTest extends TestBase {
	
	AccountLoginPage login;
	ForgotYourPasswordPage forgotPassword;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup()
	{
		initialise();
		login = new AccountLoginPage();
	}
	
	

	@Test(dataProvider = "Book1")
	public void LoginWithValidCredentials(String email, String password)
	{
	myAccountPage = login.loginToMyAccount(email,password);
	String MyAccountHeading = myAccountPage.getMyAccountHeading();
	Assert.assertEquals("My Account",MyAccountHeading);
	Assert.assertEquals("My Account", driver.getTitle());
	}
	
	@DataProvider(name ="Book1")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\johng\\OneDrive\\Desktop\\Book1.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i-1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	
	
	@Test
	public void LoginWithValidCredentials()
	{
		myAccountPage = login.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String MyAccountHeading = myAccountPage.getMyAccountHeading();
		Assert.assertEquals("My Account",MyAccountHeading);
		Assert.assertEquals("My Account", driver.getTitle());
		
	}
	
	@Test
	public void LoginWithInvalidCredentials()
	{
		login.loginToMyAccount("centanvin6@gmail.com","Password@123");
		String alertBanner = login.getAlertBannerTextVerify().trim();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBanner);
		Assert.assertEquals("Account Login", driver.getTitle());
	}
	
	@Test
	public void LoginWithValidEmailAndInvalidPassword()
	{
		login.loginToMyAccount("centanvin68@gmail.com","Password@123");
		Assert.assertEquals("Account Login", driver.getTitle());
	}
	
	@Test
	public void LoginWithInvalidEmailAndValidPassword()
	{
		login.loginToMyAccount("centanvin6@gmail.com","Password@1234");
		Assert.assertEquals("Account Login", driver.getTitle());
	}
	
	@Test
	public void ForgotPasswordFunctionality()
	{
		forgotPassword = login.clickOnForgottenPassword();
		login=forgotPassword.submitForgotPasswordRequest("centanvin68@gmail.com");
		String alertConfirmation = login.getAlertConfirmationForEmailForgotPassword().trim();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.", alertConfirmation);
	}
	
	
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
