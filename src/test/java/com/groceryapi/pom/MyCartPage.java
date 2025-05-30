package com.groceryapi.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globallib.GlobalLib;

import lombok.Data;

@Data
public class MyCartPage extends GlobalLib {
	public MyCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-toggle='modal']")
	private WebElement btnAddAddress;

	@FindBy(xpath = "//select[@id='address_type']")
	private WebElement ddnAddType;

	@FindBy(xpath = "//input[@placeholder='First name*']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@placeholder='Last name*']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@placeholder='Contact No*']")
	private WebElement txtContact;

	@FindBy(xpath = "//input[@placeholder='House No*']")
	private WebElement txtHouse;

	@FindBy(xpath = "//input[@placeholder='Address*']")
	private WebElement txtLocation;

	@FindBy(xpath = "//select[@name='state']")
	private WebElement ddnState;

	@FindBy(xpath = "//select[@name='city']")
	private WebElement ddnCity;

	@FindBy(xpath = "//input[@placeholder='Zip Code*']")
	private WebElement txtZip;

	@FindBy(xpath = "//button[contains(@class,'saveAddress ')]")
	private WebElement btnSave;

	@FindBy(xpath = "//select[@id='payment_type']")
	private WebElement ddnPayment;

	@FindBy(xpath = "//label[text()=' Visa ']")
	private WebElement chkVisa;

	@FindBy(xpath = "//input[@placeholder='Card Number']")
	private WebElement txtCard;

	@FindBy(xpath = "//select[@id='month']")
	private WebElement ddnMonth;

	@FindBy(xpath = "//select[@id='year']")
	private WebElement ddnYear;

	@FindBy(xpath = "//input[@placeholder='CVV']")
	private WebElement txtCvv;

	@FindBy(xpath = "//button[contains(text(),'Place')]")
	private WebElement btnPlaceOrder;

	public WebElement getBtnAddAddress() {
		return btnAddAddress;
	}

	public WebElement getDdnAddType() {
		return ddnAddType;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtContact() {
		return txtContact;
	}

	public WebElement getTxtHouse() {
		return txtHouse;
	}

	public WebElement getTxtLocation() {
		return txtLocation;
	}

	public WebElement getDdnState() {
		return ddnState;
	}

	public WebElement getDdnCity() {
		return ddnCity;
	}

	public WebElement getTxtZip() {
		return txtZip;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getDdnPayment() {
		return ddnPayment;
	}

	public WebElement getChkVisa() {
		return chkVisa;
	}

	public WebElement getTxtCard() {
		return txtCard;
	}

	public WebElement getDdnMonth() {
		return ddnMonth;
	}

	public WebElement getDdnYear() {
		return ddnYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnPlaceOrder() {
		return btnPlaceOrder;
	}

	public void myCart( String firstName, String lastName, String contact, String apartment, 
			String state, String city, String zip,String addType,String address) throws InterruptedException {
		elementClick(btnAddAddress);
		Thread.sleep(2000);
		selectByText(ddnAddType, addType);

		sendKeys(txtFirstName, firstName);
		sendKeys(txtLastName, lastName);
		sendKeys(txtContact, contact);
		sendKeys(txtHouse, apartment);
		sendKeys(txtLocation, address);
		selectByText(ddnState, state);
		selectByText(ddnCity, city);
		sendKeys(txtZip, zip);
		elementClick(btnSave);
		Thread.sleep(3000);

		

	}
	
	public void payment(String cardType, String cardNo,String month,String year, String cvv) {
		selectByText(ddnPayment, cardType);
		elementClick(chkVisa);
		sendKeys(txtCard, cardNo);
		// Thread.sleep(2000);
		selectByText(ddnMonth, month);
		selectByText(ddnYear, year);
		sendKeys(txtCvv, cvv);
		elementClick(btnPlaceOrder);

	}

}
