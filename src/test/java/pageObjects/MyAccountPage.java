package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//a[normalize-space()='My account'])[1]") WebElement msgHeading;
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement lnkLogout;
	
	public boolean isMyAccountExists() {
		
		try{
			return (msgHeading.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogOut() {
		lnkLogout.click();
	}
}
