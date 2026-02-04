package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC02_LoginTest extends BaseClass {
	@Test(groups="Sanity")
	public void verify_login(){
		logger.info("Starting TC02_LoginTest");
		try {
		HomePage hp=new HomePage(driver);
			hp.clickMyLogin();
			logger.info("clicked on Login");
		LoginPage lp=new LoginPage(driver);
		logger.info("providing values to the login fields");
			lp.setEmailAdress(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
		MyAccountPage mp=new MyAccountPage(driver);
			boolean targetpage=mp.isMyAccountExists();
			mp.clickLogOut();
			Assert.assertEquals(targetpage, true,"Login faliled");
		}
		catch (Exception e) {
			logger.error("test failed..");
			logger.debug("debug logs..");
			Assert.fail();
		}
		logger.info("finished TC02_LoginTest");
	}
}
