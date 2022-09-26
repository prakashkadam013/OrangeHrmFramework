package OrangeHRM_Framework_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5")
	WebElement Logo;

	public boolean verifylogo() {
		return Logo.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='username' or @placeholder='Username']")
	WebElement txtUsername;

	public void enterUsername(String username) {

		try {
			txtUsername.sendKeys(username);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@FindBy(xpath = "//input[@type='password' or @placeholder='password']")
	WebElement txtPassword;

	public void enterPassword(String password) {

		try {
			txtPassword.sendKeys(password);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@FindBy(xpath = "//button[@type='submit' or @text()='Login']")
	WebElement btnLogin;

	public void clickonLoginbutton() {

		try {
			btnLogin.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	} 
}
