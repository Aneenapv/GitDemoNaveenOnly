package com.naveenlabs.Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenlabs.RandomPackage.RandomGenerator;
import com.naveenlabs.TestBase.TestBase;

public class AddressBookPage extends TestBase{
	
	public AddressBookPage()
	{
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(css="#content tbody tr td:nth-of-type(2) a:last-of-type")
	WebElement addressDefaultDeleteButton;
	
	@FindBy(css="tbody tr:last-of-type td.text-right:nth-of-type(2) a:last-of-type")
	WebElement addressAddedDeleteButton;
	
	@FindBy(css="tbody tr:last-of-type td.text-right:nth-of-type(2) a:first-of-type")
	WebElement addressEditButton;
	
	@FindBy(id="input-firstname")
	WebElement editFirstName;
	
	@FindBy(css="div.alert")
	WebElement alertAddressBook;
	
	
	
	@FindBy(css="#content div.pull-right a")
	WebElement newAddressButton;
	
	@FindBy(id="input-firstname")
	WebElement enterFirstName;
	
	@FindBy(id="input-lastname")
	WebElement enterLastName;
	
	@FindBy(id="input-company")
	WebElement enterCompany;
	
	@FindBy(id="input-address-1")
	WebElement enterAddress;
	
	@FindBy(id="input-city")
	WebElement enterCity;
	
	@FindBy(id="input-postcode")
	WebElement enterPostCode;
	
	@FindBy(id="input-country")
	WebElement selectCountry;
	
	@FindBy(id="input-zone")
	WebElement selectRegion;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clickOnContinueButton;
	
	@FindBy(css="div.alert")
	WebElement alertMessageNewAddressAddedSuccessfully;
	
	
	public void  addressDefautDeleteButton()
	{
		addressDefaultDeleteButton.click();
	}
	
	public void addressAddedDeleteButton()
	{
		addressAddedDeleteButton.click();
	}
	
	public void addressEditButton()
	{
		addressEditButton.click();
	}
	
	public void editFirstName()
	{
		editFirstName.clear();
		editFirstName.sendKeys("Kochouseph");
	}
	
	public void editAddressBook()
	{
		addressEditButton();
		editFirstName();
		selectDropDownCommonMethod(selectCountry,"American Samoa","4");
		selectDropDownCommonMethod(selectRegion,"Rose Island","119");
		clickOnContinueButton();
	}
	
	
	
	public String getAlertAddressBook()
	{
		return alertAddressBook.getText().trim();
	}
	
	public void newAddressButton()
	{
		newAddressButton.click();
	}
	
	public void enterFirstName(String firstName)
	{
		enterFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		enterLastName.sendKeys(lastName);
	}
	
	public void enterCompany()
	{
		enterCompany.sendKeys("pivot");
	}
	
	public void enterAddress()
	{
		enterAddress.sendKeys("drury boulevard");
	}
	
	public void enterCity()
	{
		enterCity.sendKeys("Brampton");
	}
	
	public void enterPostCode()
	{
		enterPostCode.sendKeys("L1L2L3");
	}
	
/*	public void selectCountry()
	{
		Select select = new Select(selectCountry);
		select.selectByVisibleText("American Samoa");
	}
	
	public void selectRegion()
	{
		Select select = new Select(selectRegion);
		select.selectByVisibleText("Rose Island");
	} */
	
	public void  clickOnContinueButton()
	{
		 clickOnContinueButton.submit();
	}
	
	public String getAlertMessageNewAddressAddedSuccessfully()
	{
		return alertMessageNewAddressAddedSuccessfully.getText().trim();
	}
	
	public AddressBookPage addNewAddress()
	{
		newAddressButton();
		enterFirstName(RandomGenerator.RandomNameGenerator());
		enterLastName(RandomGenerator.RandomNameGenerator());
		enterCompany();
		enterAddress();
		enterCity();
		enterPostCode();
		
		//selectCountry();
		//selectRegion();
		
		selectDropDownCommonMethod(selectCountry,"American Samoa","4");
		selectDropDownCommonMethod(selectRegion,"Rose Island","119");
		
		clickOnContinueButton();
		return new  AddressBookPage();
	}
	
	
}
