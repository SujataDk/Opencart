package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.MyAccountPage;
import utilities.Dataprovider;

public class TC0003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass= Dataprovider.class )   //getting dataprovider class from different package
	public void verify_loginDDT(String email, String pwd, String Exp) {
		
		try {
	    
	    // HomePage
	    HomePage hp = new HomePage(driver);
	    hp.clickMyAccount();
	    hp.clicklogin();
	    
	    // Login
	    Login lp = new Login(driver);
	    lp.enteremail(email);
	    lp.enterpass(pwd);
	    lp.clickLogin();
	    
	    // MyAccount
	    MyAccountPage macc = new MyAccountPage(driver);
	    boolean targetPage = macc.isMyAccountPageExists();
	    
	    
	    /*
	    Data is valid - login success - test pass - logout
	                   - login failed  - test fail

	    Data is invalid - login success - test fail - logout
	                     - login failed - test pass
	    */

	    if (Exp.equalsIgnoreCase("Valid")) {
	        if (targetPage == true) {
	            Assert.assertTrue(true);
	            macc.clickLogout();
	        } else {
	            Assert.assertTrue(false);
	        }
	    }
	    
	    if (Exp.equalsIgnoreCase("Invalid")) {
	        if (targetPage == true) {
	            macc.clickLogout();
	            Assert.assertTrue(false);
	        } 
	        else {
	            Assert.assertTrue(true);
	        }
	}}
	catch(Exception e)
	{
		Assert.fail();
		}
	


}}
