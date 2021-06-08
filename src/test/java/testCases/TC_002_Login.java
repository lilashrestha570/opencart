package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass{
	
	
	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info("String TC_002_Login");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed");
			
			driver.manage().window().maximize();
			
			Homepage hp=new Homepage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password");
			
			lp.clickLogin();
			logger.info("Click on Login");
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			if(targetpage)
			{
				logger.info("Login Success");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed");
				captureScreen(driver,"test_Login");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed");
			Assert.fail();
		}
		logger.info("Finished TC_002_Login");
	}

}
