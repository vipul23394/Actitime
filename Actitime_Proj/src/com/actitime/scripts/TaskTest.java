package com.actitime.scripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtils;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageobject.ActiveProjAndCustPage;
import com.actitime.pageobject.CreateNewCustPage;
import com.actitime.pageobject.EditCustInformaPage;
import com.actitime.pageobject.LoginPage;
import com.actitime.pageobject.OpenTaskPage;

public class TaskTest extends BaseLib {
	@Test
	public void createCustomerTest(){
		LoginPage lp = new LoginPage(driver);
		lp.login(ExcelUtils.readData("Sheet1", 2, 1), ExcelUtils.readData("Sheet1", 2, 2));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
 		}
		OpenTaskPage otp = new OpenTaskPage(driver);
		otp.clickOnProjAndCust();
		ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);
		WaitStatementLib.implicitWaitForSeconds(driver, 20);
		apcp.clickOnCreateNewCustBtn();
		CreateNewCustPage cncp = new CreateNewCustPage(driver);
				cncp.createCustomer(ExcelUtils.readData("Sheet1", 2, 3));
				WaitStatementLib.explicitWaitForVisibility(driver, 20, apcp.getSuccessMsg());
				apcp.verifyCreatedCustMsg();
	}
	
	@Test
	public void deleteCustomerTest(){
		LoginPage lp = new LoginPage(driver);
		lp.login(ExcelUtils.readData("Sheet1", 3, 1), ExcelUtils.readData("Sheet1", 3, 2));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		OpenTaskPage otp = new OpenTaskPage(driver);
		otp.clickOnProjAndCust();
		WaitStatementLib.implicitWaitForSeconds(driver, 20);
		
		ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);
		apcp.clickOnCustomer(driver, ExcelUtils.readData("Sheet1", 3, 3));
		WaitStatementLib.implicitWaitForSeconds(driver, 20);
		
		EditCustInformaPage ecip = new EditCustInformaPage(driver);
		ecip.deleteCustomer();
		
		apcp.verifyDeleteCustMsg();
		apcp.clickOnLogoutLink();
		
	
		
	}
	
	

}
