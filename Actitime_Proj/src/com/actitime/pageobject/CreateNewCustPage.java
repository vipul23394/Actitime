package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustPage {
	@FindBy(name="name")
	private WebElement custNameTxtField;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustSubmitBtn;
	
	public CreateNewCustPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	public void createCustomer(String customerName){
		custNameTxtField.sendKeys(customerName);
		createCustSubmitBtn.click();
	}
	

}
