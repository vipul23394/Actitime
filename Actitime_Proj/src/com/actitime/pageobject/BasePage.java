package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogoutLink(){
		logoutLink.click();
	}


}
