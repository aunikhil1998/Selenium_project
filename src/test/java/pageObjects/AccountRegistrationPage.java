package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='gender-male']") WebElement btngender;
	@FindBy(xpath="//input[@id='FirstName']") WebElement txtfname;
	@FindBy(xpath="//input[@id='LastName']") WebElement txtlname;
	@FindBy(xpath="//input[@id='Email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='Password']") WebElement txtpassword;
	@FindBy(xpath="//input[@id='ConfirmPassword']") WebElement txtconfirmpassword;
	@FindBy(xpath="//button[@id='register-button']") WebElement btnregister;
	@FindBy(xpath="//div[text()='Your registration completed']") WebElement msgconfirm;
	
	public void setGender() {
		btngender.click();
	}
	public void setFirstName(String fname) {
		txtfname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtlname.sendKeys(lname);
	}
	public void setemail(String mail) {
		txtemail.sendKeys(mail);
	}
	public void setPassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	public void setconfirmPassword(String ConfirmPass) {
		txtconfirmpassword.sendKeys(ConfirmPass);
	}
	public void clickRigister() {
		btnregister.click();
	}
	public String getconfirmationMessage() {
		try {
			return(msgconfirm.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}



	
}
