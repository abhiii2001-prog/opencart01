package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegiatrtionForm extends BasePage{
	
	public AccountRegiatrtionForm(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	
	WebElement txtlasttname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement chknewslater;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkagree;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement Button;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtverify;
	
	public void setfirstname(String firstname) {
		txtfirstname.sendKeys(firstname);
	}
	public void setlastname(String lastname) {
		txtlasttname.sendKeys(lastname);
	}
	
	public void setemail(String email) {
		 txtemail.sendKeys(email);
	}
	public void setPassword(String password) {
		 txtpassword.sendKeys(password);
	}
	public void chknewslater() {
		chknewslater.click();
	}
	
	 public void chkagree() {
		chkagree.click();
	}
	 
	 public void Buttton() {
			Button.click();
		}
	 
	 public String getconfirmationmsg() {
		 try {
			return  txtverify.getText();
		 }
		catch(Exception e) {
			return (e.getMessage());
		}
	 }
		 
	
}
