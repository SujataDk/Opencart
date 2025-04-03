package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.MyAccountPage;

public class TC002_Login extends BaseClass {
	
	
	@Test(groups={"master"})
	public void verifyLogin()
	{
		try {
		HomePage Hm=new HomePage(driver);
	Hm.clickMyAccount();
	Hm.clicklogin();
	
		Login L1= new Login(driver);
		L1.enteremail(p.getProperty("email"));
        L1.enterpass(p.getProperty("password"));
        L1.clickLogin();
        
        MyAccountPage myAccPage= new MyAccountPage(driver);
        boolean targetPage = myAccPage.isMyAccountPageExists();

        Assert.assertTrue(targetPage);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
        
	}
	
	
	
	

}
