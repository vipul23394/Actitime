 	package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	//final driver
	public WebDriver driver;
	@BeforeMethod
	@Parameters(value="browser")
	public void precondition(String browserName){
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Firefox Launched", true);
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\exe files\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome Launched", true);
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\exe files\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("IE Launched", true);
		}
		driver.manage().window().maximize();
		driver.get(GetPropertyValues.getPropertyValue("testURL"));
		Reporter.log("Navigating to the test URL");
		
	}
	@AfterMethod
	public void postCondition(ITestResult result){
		if (result.isSuccess()) {
			Reporter.log("Script passed", true);
		}
		else {
			Reporter.log("Script", true);
			String fileName = result.getMethod().getMethodName();
			ScreenshotLib sLib = new ScreenshotLib();
			sLib.getScreenshot(driver, fileName);
			Reporter.log("Screenshot has been taken", true);
		}
		driver.close();
		Reporter.log("Browser closed", true);
		
	}

}
