package com.groceryapi.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globallib.GlobalLib;

import lombok.Data;


@Data
public class LoginPage extends GlobalLib {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5[starts-with(text(),'Welcome ')]")
	private WebElement txtWelcome;
	@FindBy(xpath="//input[@id='email']")
	private WebElement txtUser;
	
	@FindBy(xpath="//img[@alt='Grocery']")
	private WebElement grocery;
	
	@FindBy(id="pass")
	private WebElement txtPass;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement btnLogin;

	public  WebElement getTxtUser() {
		return txtUser;
	}

	public   WebElement getTxtPass() {
		return txtPass;
	}
	
	public void login(String userName,String Pass) {
		sendKeys(txtUser, userName);
		sendKeys(txtPass, Pass);
		elementClick(btnLogin);
		
	}
	public void grocery() {
		
		grocery.click();


	}
	
	

}
