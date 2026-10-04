package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.MyaccountPage;

public class TC_002AccountlLoginTest extends Baseclass {
	@Test(groups="sanity")
	public void verifyLogin() {
	logger.info("****************Starting Tc002 LoginTest*****************");
	try {
	Homepage hp = new Homepage(driver);
	Loginpage lp = new Loginpage(driver);
	MyaccountPage mp= new MyaccountPage(driver);
	hp.clickMyAcccount();
	hp.clickonlogin();
	lp.inputemail(p.getProperty("email"));
	lp.setpassword(p.getProperty("pwd"));
	lp.clicllogin();
	
	
	Assert.assertTrue(mp.chksuccessfulLogin());
	
	}
	catch(Exception e) {
		Assert.fail();
		
	}
	logger.info("****************finish Tc002 LoginTest*****************");
	}
	

}
