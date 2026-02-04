package testCases;

import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import org.testng.Assert;

public class TC_AccountRegistrationTest extends BaseClass{
	@Test(groups="Regression")
	public void verify_account_reg() {
		logger.info("Starting TC_AccountRegistrationTest ");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyRegister();
		logger.info("clicked on register link");
		AccountRegistrationPage reg=new AccountRegistrationPage(driver);
		logger.info("providing values to the registration fields");
			reg.setGender();
			reg.setFirstName(randomeString().toUpperCase());
			reg.setLastName(randomeString().toUpperCase());
			reg.setemail(randomeString()+"@gmail.com");
			String password=randomeAlphnumeric();
			reg.setPassword(password);
			reg.setconfirmPassword(password);
			reg.clickRigister();
			logger.info("Validating confirm message for successfull registration");
			String confmessage=reg.getconfirmationMessage();
			if(confmessage.equals("Your registration completed")) {
				Assert.assertTrue(true);
			}else {
				logger.error("test failed..");
				logger.debug("debug logs..");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e){
			
			Assert.fail();
		}
		logger.info("Starting TC_AccountRegistrationTest ");
	}
		
}
