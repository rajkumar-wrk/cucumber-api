package com.groceryapi.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globallib.GlobalLib;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data


public class ProductListingPage extends GlobalLib{
	
	public ProductListingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h5[starts-with(text(),'Happilo ')]//following-sibling::div//a[text()='Add']")
	private WebElement btnHappilo;
	
	@FindBy(xpath="//button[text()='Add' and @id='cart-23']")
	private WebElement btnHappilo500gms;
	
	@FindBy(xpath = "//h5[starts-with(text(),'Happilo ')]")	
	private WebElement txtHappilo;
	
	@FindBy(xpath="//a[contains(@class,'addBtn-17')]")
	private WebElement btnAdd;
	
	@FindBy(xpath="//button[@id='cart-22']")
	private WebElement btnAddToCart;
	
	@FindBy(xpath="//a[text()=' Go To Cart ']")
	private WebElement btnGoToCart;
	
	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getBtnAddToCart() {
		return btnAddToCart;
	}

	public WebElement getBtnGoToCart() {
		return btnGoToCart;
	}

	
	
	public void productListing() {
		elementClick(btnAdd);
		elementClick(btnAddToCart);
		jsClick(btnGoToCart);

	}
	
	
	

}
