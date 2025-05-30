package com.groceryapi.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globallib.GlobalLib;

import lombok.Data;

@Data
public class OrderIdPage extends GlobalLib {

	public OrderIdPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtUser;

	@FindBy(id = "pass")
	private WebElement txtPass;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[contains(text(),'Welcome ')]")
	private WebElement lnkWelcome;

	@FindBy(xpath = "//a[text()='Grocery Settings']")
	private WebElement grocerySetting;

	@FindBy(xpath = "//a[text()='orders']")
	private WebElement lnkOrder;

	@FindBy(xpath = "(//a[text()='More Details'])[1]")
	private WebElement lnkMoreDetails;

	@FindBy(xpath = "//p[contains(text(),'Order No: ')]")
	private WebElement txtOrderId;

	@FindBy(xpath = "//img[@alt='Grocery']")
	private WebElement grocery;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getLnkWelcome() {
		return lnkWelcome;
	}

	public WebElement getLnkMyAccount() {
		return grocerySetting;
	}

	public WebElement getLnkOrder() {
		return lnkOrder;
	}

	public WebElement getLnkMoreDetails() {
		return lnkMoreDetails;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public String getOrderId(String user, String pass) {

		sendKeys(txtUser, user);
		sendKeys(txtPass, pass);
		elementClick(btnLogin);

		elementClick(lnkWelcome);
		elementClick(grocerySetting);
		elementClick(lnkOrder);
		elementClick(lnkMoreDetails);
		String elementGetText = elementGetText(txtOrderId);
		System.out.println("orderNo " + elementGetText);
		return elementGetText;
	}

}
