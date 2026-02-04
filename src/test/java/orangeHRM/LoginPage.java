package orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//locators
	
	@FindBy(xpath="//input[@name='username']") WebElement text_username_loc;
	@FindBy(xpath="//input[@name='password']") WebElement text_password_loc;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btn_login_loc;
	
	/**By text_username_loc=By.xpath("//input[@name='username']");
	By text_password_loc=By.xpath("//input[@name='password']");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");**/
	
	//actions
	
	public void setusername(String user) {
		text_username_loc.sendKeys(user);
	}
	
	public void setpassword(String pass) {
		text_password_loc.sendKeys(pass);
	}
	
	public void clicklogin() {
		btn_login_loc.click();
	}
	
}
