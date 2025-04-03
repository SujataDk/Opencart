package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement Elepresent;
	
	
	@FindBy(xpath="(//a[normalize-space()='Logout'])[1]")
	WebElement clickLogout;
	
	
	
	public boolean isMyAccountPageExists() {
	    try {
	        return (Elepresent.isDisplayed());
	    } catch (Exception e) {
	        return false;
	    }
	}


	public void clickLogout() {
		
		clickLogout.click();
		
	}
	
	

	

	    
	


}
