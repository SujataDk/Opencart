package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage{

	public Login(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement enteremail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement enterpassword;
	

	@FindBy(xpath="//input[@value='Login']")
	WebElement Clicklogin;
	
	public void enteremail(String email)
	{
	enteremail.sendKeys(email);
	}
	
	public void enterpass(String pass)
	{
	enterpassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
	Clicklogin.click();
	}
	
	

}
