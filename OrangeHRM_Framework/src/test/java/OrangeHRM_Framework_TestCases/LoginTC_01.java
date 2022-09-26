package OrangeHRM_Framework_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import OrangeHRM_Framework_PageObject.LoginPage;
import OrangeHRM_Framework_TestBase.TestBase;
import OrangeHRM_Framework_Utilities.ExcelDataProvider;

public class LoginTC_01 extends TestBase {

	LoginPage lp;

	@Test(priority=1)
	public void VerifyLogo() {
		
		extentTest = extentreports.createTest("VerifyLogo");
		lp = new LoginPage(driver);
		if (lp.verifylogo()) {
			Assert.assertTrue(true);
		//	System.out.println("Logo is verified");
			extentTest.info("Logo is verified");
		} else {
			//System.out.println("Logo is not verified");
			extentTest.info("Logo is not verified");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=2)
	public void VerifyPageTitle() {
		
		extentTest = extentreports.createTest("VerifyPageTitle");
		String Pagetitle = driver.getTitle();
		if (Pagetitle.equals("OrangeHRM")) {
			Assert.assertTrue(true);
			//System.out.println("Page Title is verified");
			extentTest.info("Page Title is verified");
		} else {
			//System.out.println("Page Title is not verified");
			extentTest.info("Page Title is not verified");
			Assert.assertTrue(false);
		}
	}
	
/*	@Test(priority=3)
	public void LoginTestcase() {
		lp = new LoginPage(driver);
		lp.enterUsername("Admin");
		lp.enterPassword("admin12");
		lp.clickonLoginbutton();
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
		
		if(ele.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Login is Sucess");
		} else {
			System.out.println("Login is Failed");
			Assert.assertTrue(false);
		}
	} */
	
 /*	@Test(priority=3)
	public void LoginTestcase() {
		lp = new LoginPage(driver);
		lp.enterUsername(ConfigDataprovider.getUsername());
		lp.enterPassword(ConfigDataprovider.getPassword());
		lp.clickonLoginbutton();
		
		if(driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login is Sucess");
		} else {
			System.out.println("Login is Failed");
			Assert.assertTrue(false);
		}
	} */
	
	@Test(priority=3,enabled=false)
	public void LoginTestcase_Excel() {
		
		extentTest = extentreports.createTest("LoginTestcase_Excel");

		lp = new LoginPage(driver);
		lp.enterUsername(ExcelDataProvider.getStringCellData("Sheet1", 1, 0));
		lp.enterPassword(ExcelDataProvider.getStringCellData("Sheet1", 1, 1));
		lp.clickonLoginbutton();
		
		if(driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login is Sucess");
		} else {
			System.out.println("Login is Failed");
			Assert.assertTrue(false);
		}
	}
}
