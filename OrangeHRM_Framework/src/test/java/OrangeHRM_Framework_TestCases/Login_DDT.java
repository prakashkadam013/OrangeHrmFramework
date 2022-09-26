package OrangeHRM_Framework_TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OrangeHRM_Framework_PageObject.LoginPage;
import OrangeHRM_Framework_TestBase.TestBase;
import OrangeHRM_Framework_Utilities.ExcelDataProvider;


public class Login_DDT extends TestBase {
	
	LoginPage lp;
	public static ExcelDataProvider excelDataProvider = new ExcelDataProvider("./TestData/Data.xlsx");
	
	@Test(dataProvider="getData")
	public void LoginDDT(String username, String password) {
		lp = new LoginPage(driver);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickonLoginbutton();
		
		if(driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login success");
		} else if(driver.getPageSource().contains("Invalid credentials")) {
			Assert.assertTrue(true);
			System.out.println("Invalid Credential Login fail");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login fail");
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = ExcelDataProvider.getExcelData("Sheet1");
		return data;
	}
	
}
