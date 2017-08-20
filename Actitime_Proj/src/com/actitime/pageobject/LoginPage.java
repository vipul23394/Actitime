package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(name="username")
	private WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(className="errormsg")
	private WebElement invalidLoginMsg;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getInvalidLoginMsg() {
		return invalidLoginMsg;
	}
	public void login(String username,String password){
		unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);
		loginBtn.click();
	}
	public void verifyInvalidMsg(){
		String expMsg="Username or Password is invalid. Please try again.";
		String actMsg = invalidLoginMsg.getText();
		Assert.assertEquals(actMsg, expMsg, "Invalid Login Msg is not Verified");
		Reporter.log("Invalid Mesg is Verified", true);
		
		
	}

}
