package Baseclass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;// Log4J

    
    @BeforeClass(groups={"Sanity","master"})
    @Parameters({"os", "browser"})
    public void setup(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException {
    	
    	FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
    	
        logger = LogManager.getLogger(this.getClass()); // Log4J2

        switch (br.toLowerCase()) {
            case "chrome": 
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge": 
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox": 
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default: 
                System.out.println("Invalid browser name.."); 
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the test URL
        driver.get(p.getProperty("appURL2"));    //reading URL from properties file
        driver.manage().window().maximize();
    }


  @AfterClass(groups={"Sanity","master"})
    public void tearDown() {
        driver.quit();
    }
    
    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    
    public String randomnumber() {
        String generatedString = RandomStringUtils.randomNumeric(10);
        return generatedString;
    }
    public String randomAlphaNumeric() {
        @SuppressWarnings("deprecation")
		String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return (generatedString + "@" + generatedNumber);
    }

}
