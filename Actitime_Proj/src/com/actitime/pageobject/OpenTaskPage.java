package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenTaskPage {
	
	public void verifyHomePage(WebDriver driver){
		String expHPTitle="actiTIME - Open Tasks";
		String actHPTitle = driver.getTitle();
		Assert.assertEquals(expHPTitle, actHPTitle, "Home Page title is not verified");
		Reporter.log("Home page is verified", true);
	}
	@FindBy(linkText="Projects & Customers")
	private WebElement projAndCustLink;
	
	public OpenTaskPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickOnProjAndCust(){
		projAndCustLink.click();
		
	}

}
