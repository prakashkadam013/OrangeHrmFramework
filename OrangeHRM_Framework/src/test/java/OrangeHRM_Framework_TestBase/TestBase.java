package OrangeHRM_Framework_TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import OrangeHRM_Framework_Utilities.ConfigDataProvider;
import OrangeHRM_Framework_Utilities.ConstantVariable;
import OrangeHRM_Framework_Utilities.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public static ConfigDataProvider ConfigDataprovider;
	public static ExcelDataProvider excelDataProvider;
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	
	@BeforeSuite
	public void init() {
		ConfigDataprovider = new ConfigDataProvider(ConstantVariable.configDataProviderPath);
		excelDataProvider = new ExcelDataProvider("./TestData/Data.xlsx");
		
		extentHtmlReporter = new ExtentHtmlReporter("./Reports/extentReports.html");
		extentHtmlReporter.config().setDocumentTitle("Automation Test Reports");
		extentHtmlReporter.config().setReportName("RT Test Report");
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
		
		extentreports = new ExtentReports();
		extentreports.attachReporter(extentHtmlReporter);
		extentreports.setSystemInfo("Hostname", "Local Host");
		extentreports.setSystemInfo("OS", "Windows");
		extentreports.setSystemInfo("Browser", "Chrome");
		extentreports.setSystemInfo("TE", "Raman");
		extentreports.setSystemInfo("Test Cases", "RT");

		
	}
	
	
	@BeforeMethod
	@Parameters({"brname"})
	public void LaunchTheBrowser(@Optional("Chrome")String browser) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("No Browser availabe");
		}

		driver.manage().window().maximize();
		driver.get(ConfigDataprovider.getAppUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void CloseTheBrowser() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
	}
	
	@AfterTest
	public void extentFlush() {
		extentreports.flush();
	}
}
