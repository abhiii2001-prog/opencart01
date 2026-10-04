package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	//WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
		
	}

	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount ;
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	
	
	
	
	// Actions 

	public void clickMyAcccount() {
		myaccount.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickonlogin() {
		login.click();
	}
}



