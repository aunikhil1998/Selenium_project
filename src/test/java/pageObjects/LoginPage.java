package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='Email']") WebElement txtEmailAdress;
	@FindBy(xpath="//input[@id='Password']") WebElement txtPassword;
	@FindBy(xpath="//button[normalize-space()='Log in']") WebElement btnLogin;
	
	public void setEmailAdress(String user) {
		txtEmailAdress.sendKeys(user);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
}
