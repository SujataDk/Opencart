package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.ResistrationPge;

public class TC001_resistarion extends BaseClass{
    
    @Test(groups={"Sanity", "master"})
    public void verify_account_risistration()
    {
    	
  logger.info("logs message started");
  try {
    	HomePage hp=new HomePage(driver);
    		hp.clickMyAccount()	;
    	    hp.clickRegister();
    	    
    	    logger.info("clicked on register buten");
    	    ResistrationPge regpage = new ResistrationPge(driver);
    	
    	    logger.info("user details enter here");
    	    regpage.setFirstName(randomString().toUpperCase());
    	    regpage.setLastName(randomString().toUpperCase());
    	    regpage.setEmail(randomString() + "@gmail.com"); // randomly generated email
    	    regpage.setTelephone(randomnumber());

    	    String password=randomAlphaNumeric();
    	   regpage.setPassword(password);
    	    regpage.setConfirmPassword(password);

    	    regpage.setPrivacyPolicy();
    	    regpage.clickContinue();
    	    
    	    logger.info("validating expected msg here");
    	    String cofirmmsg=regpage.getConfirmationMsg();
    	    if(cofirmmsg.equals("Your Account Has Been Created!"))
    	    {
    	    	Assert.assertTrue(true);
    	    	
    	    }
    	    else 
    	    {
    	    	Assert.assertTrue(false);
    	    	logger.error("Test failed..");
        	    logger.debug("Debug logs..");
    	    }
    }
    
    	catch(Exception e) {
    	   
    	    Assert.fail();
    	}



    
    
}}
