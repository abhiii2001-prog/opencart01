package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {
	public MyaccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath=" //h1[normalize-space()='My Account']")
	WebElement verificationmsg;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	public boolean chksuccessfulLogin() {
		try {
			return verificationmsg.isDisplayed();
		}
		
	catch(Exception e) {
		return false;
	}
	}
	public void clicklogout() {
		logout.click();
	}

}
