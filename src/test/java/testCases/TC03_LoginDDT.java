package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
 public void Verify_LoginDDT(String email, String pass, String exp) {
		logger.info("Starting the TC03_LoginDDT");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyLogin();
		logger.info("clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("providing values to the login fields");
		lp.setEmailAdress(email);
		lp.setPassword(pass);
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetpage=mp.isMyAccountExists();
		if(exp.equalsIgnoreCase("valid")) {
			if(targetpage==true) {
				mp.clickLogOut();
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetpage==true) {
				mp.clickLogOut();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("Ended the TC03_LoginDDT");
	}
	
}