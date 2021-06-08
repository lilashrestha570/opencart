package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.Homepage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{
	

		@Test(groups= {"regression","master"})
		public void test_account_Registration()
		{
			try
			{
			logger.info("Sarting TC_001_AccountRegistration");
			
			driver.get(rb.getString("appURL"));
			logger.info("Home Page displayed");
			
			driver.manage().window().maximize();
			
			Homepage hp=new Homepage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.clickRegister();
			logger.info("Clicked on Register ");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			regpage.setFirstName("John");
			logger.info("Provided Firt Name");
			
			regpage.setLastName("Canedy");
			logger.info("Provided Last Name");
			
			regpage.setEmail(randomestring()+"@gmail.com");
			logger.info("Provided Email");
			
			regpage.setTelephone("65656565");
			logger.info("Provided Telephone");
			
			regpage.setPassword("abcxyz");
			logger.info("Provided Password");
			
			regpage.setConfirmPassword("abcxyz");
			logger.info("Provided Confirm Password");
			
			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy ");
			
			regpage.clickContinue();
			logger.info("Clicked on Continue ");
			
			String confmsg=regpage.getConfirmationMsg();
			
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Account Registration Success");
				Assert.assertTrue(true);
			}
			else
			{
			logger.info("Account Registration is Failed");
			captureScreen(driver,"test_account_Registration");
			Assert.assertTrue(false);
			}
			}
		
			catch(Exception e)
			{
			logger.info("Account Registration is Failed");
			Assert.fail();
		}
			logger.info("Finished TC_001_AccountRegistration");
		}	
			
	}


		

