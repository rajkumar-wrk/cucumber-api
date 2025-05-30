package com.groceryapi.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globallib.GlobalLib;



public class SearchProductPage extends GlobalLib {
	
	public SearchProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='search']")
	private WebElement txtSearchBox;
	
	@FindBy(xpath="//button[@href='javascript:;']")
	private WebElement btnSearch;
	
	
	
	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}



	public WebElement getBtnSearch() {
		return btnSearch;
	}



	public void searchProduct(String product) {
		sendKeys(txtSearchBox, product);
		elementClick(btnSearch);
	}
	
	
	
}
