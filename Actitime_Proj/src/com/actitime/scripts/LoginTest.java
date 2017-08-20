package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtils;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageobject.LoginPage;
import com.actitime.pageobject.OpenTaskPage;

public class LoginTest extends BaseLib {
	@Test(priority=1)
	public void validLoginTest(){
		LoginPage lp = new LoginPage(driver);
		String username = ExcelUtils.readData("Sheet1", 0, 1);
		String password = ExcelUtils.readData("Sheet1", 0, 2);
		lp.login(username, password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		OpenTaskPage otp = new OpenTaskPage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//WaitStatementLib.implicitWaitForSeconds(driver, 20);
		otp.verifyHomePage(driver);
	}
	@Test(priority=2)
	public void invalidLoginTest(){
		LoginPage lp = new LoginPage(driver);
		lp.login(ExcelUtils.readData("Sheet1", 1, 1), ExcelUtils.readData("Sheet1", 1, 2));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lp.verifyInvalidMsg();
	}

}
