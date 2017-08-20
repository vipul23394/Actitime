package com.actitime.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjAndCustPage extends BasePage {
	@FindBy(css = "input[value='Create New Customer']")
	private WebElement createNewCustBtn;

	@FindBy(className = "successmsg")
	private WebElement successMsg;

	@FindBy(name = "selectedCustomer")
	private WebElement selectedCustDwn;

	@FindBy(xpath = "//input[contains(@value,'Show')]")
	private WebElement custShowBtn;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public ActiveProjAndCustPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void clickOnCreateNewCustBtn() {
		createNewCustBtn.click();
	}

	public void verifyCreatedCustMsg() {
		Assert.assertTrue(successMsg.isDisplayed(), "Create cust msg is not Verified");
		Reporter.log(successMsg.getText(), true);
	}

	public void clickOnCustomer(WebDriver driver, String customerName) {
		Select sel = new Select(selectedCustDwn);
		sel.selectByVisibleText(customerName);
		custShowBtn.click();

		driver.findElement(By.xpath("//a[text()='" + customerName + "']")).click();

	}

	public void verifyDeleteCustMsg() {
		String expMsg = "Customer has been successfully deleted.";
		String actMsg = successMsg.getText();
		Assert.assertEquals(actMsg, expMsg, "Delete Cust is not Verified");
		Reporter.log("Deleted cust is verified ", true);
	}

}
