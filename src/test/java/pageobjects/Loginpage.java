package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	
	public class Loginpage extends BasePage{
		public Loginpage(WebDriver driver) {
			super(driver);
		}
	
	
	@FindBy(xpath=" //input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbtn;

	
	
	public void inputemail(String email) {
		Email.sendKeys(email);
		
	}
	
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
		
	}
	
	public void clicllogin() {
	loginbtn.click();
		
	}
	
}
