package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.MyaccountPage;
import utilities.Dataproviders;

public class TC003loginDDt extends Baseclass {
	
	
		@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)
		public void verify_looginDDt(String email,String pwd,String expResult) {
			logger.info("****************Starting Tc003 LoginTest*****************");
			try {
			Homepage hp =new Homepage(driver);
			hp.clickMyAcccount();
			hp.clickonlogin();
			
			Loginpage lp = new Loginpage(driver);
			lp.inputemail(email);
			lp.setpassword(pwd);
			lp.clicllogin();
			MyaccountPage mp= new MyaccountPage(driver);
			boolean targetpage = mp.chksuccessfulLogin();
			
			if(expResult.equals("valid")) {
				if(targetpage== true) {
					mp.clicklogout();
					Assert.assertTrue(true);
					
					
				}
				else {
					Assert.assertTrue(false);
				}
				
				
			}if(expResult.equals("invalid")) {
				if(targetpage==true) {
					mp.clicklogout(); 
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			}
			catch(Exception e) {
				Assert.assertTrue(false);
			}
				
			
			
			logger.info("****************Ending Tc002 LoginTest*****************");
		}
	
	
		
}
