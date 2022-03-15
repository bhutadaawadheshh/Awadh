package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.CheckoutPage;
import pom.InventoryPage;
import pom.LoginPage;
import pom.OverviewPage;
import pom.ThankYouPage;
import pom.YourCartPage;

public class VerifyCompleteFlow {
	
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
		System.out.println("verifyInventoryPage");
		InventoryPage inventorypage = new InventoryPage(driver);
		
		inventorypage.sortByProduct();
		inventorypage.addProductToCart();
		inventorypage.clickOnCart();
	
		System.out.println("verifyYourCartPage");
		YourCartPage yourcartpage = new YourCartPage(driver);
		
		yourcartpage.clickOnCheckout();
	
		System.out.println("verifyCheckoutPage");
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		
		checkoutpage.enterFirstName();
		checkoutpage.enterLastName();
		checkoutpage.enterPostalCode();
		checkoutpage.clickOnContinue();
		
		System.out.println("verifyOverviewPage");
		OverviewPage overviewpage = new OverviewPage(driver);
		
		overviewpage.clickOnFinish();
		
		System.out.println("verifyThankYouPage");
		ThankYouPage thankyoupage = new ThankYouPage(driver);
		
		thankyoupage.clickOnHome();		
	}
	
	@AfterMethod
	public void logoutOfApplication() 
	{
		System.out.println("logoutOfApplication");
	}
	
	@AfterClass
	public void closeBrower() 
	{   
		driver.quit();
		System.out.println("BrowserClosed");
	}
}
