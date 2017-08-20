package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustInformaPage {
	@FindBy(xpath="//input[@value='Delete This Customer']")
	private WebElement delThisCustBtn;
	
	@FindBy(id="deleteButton")
	private WebElement delCustConfBtn;
	
	public EditCustInformaPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void deleteCustomer(){
		delThisCustBtn.click();
		delCustConfBtn.click();
	}
	

}
