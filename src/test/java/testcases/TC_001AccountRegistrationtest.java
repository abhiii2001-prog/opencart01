package testcases;



import org.testng.Assert;


import org.testng.annotations.Test;

import pageobjects.AccountRegiatrtionForm;
import pageobjects.Homepage;

public class TC_001AccountRegistrationtest extends Baseclass {
	

	
	
	@Test(groups="regression")
	public void verifyAccountRegistration() {
		try {
		Homepage hp = new Homepage(driver);
		logger.info("click on my account link");
		hp.clickMyAcccount();
		logger.info("Click on Register");
		hp.clickRegister();
		
		AccountRegiatrtionForm regform=new AccountRegiatrtionForm(driver);
		logger.info("Providing customer Details");
		regform.setfirstname(randomString());
		regform.setlastname(randomString());
		regform.setemail(randomAlphaNumber()+"@gmail.com");
		regform.setPassword(randomAlphaNumber());
		regform.chknewslater();
		regform.chkagree();
		regform.Buttton();
		String acttext = regform.getconfirmationmsg();
		logger.info("Doing validation");
		Assert.assertEquals(acttext, "Your Account Has Been Created!");
		
		
	}
		catch(Exception e) {
			logger.error("Test failed.....");
			logger.debug("debug logs");
			Assert.fail();
			
		}
		
  
	}

	
	

}
