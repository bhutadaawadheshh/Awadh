package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.LoginPage;

public class VerifyLoginPage {

	private WebDriver driver;
	private LoginPage loginpage;
	
	
		@BeforeClass
		public void launchBrowser() 
		{
			System.out.println("launchBrowser");
			ChromeOptions options = new ChromeOptions();        
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","G:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
			System.out.println("launchBrowser");
		}
		
		@BeforeMethod
		public void loginToApplication() 
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.saucedemo.com/");
			
	        loginpage = new LoginPage(driver);
	        
	        loginpage.enterUsername();
	        loginpage.enterPassword();
	        loginpage.clickOnLoginButton();
	        System.out.println("loginToApplication");
		}
        

		@Test (priority = 0)
		public void verifyInventoryPage() 
		{
			
		
        if((driver.getCurrentUrl()).equals("https://www.saucedemo.com/inventory.html"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
        }
        
		}
	
}
