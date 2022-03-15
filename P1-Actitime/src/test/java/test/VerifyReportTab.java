 package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom.HeaderPage;
import pom.LoginPage;
import utils.Utility;

public class VerifyReportTab {
     
	private WebDriver driver;
	private HeaderPage headerPage;
	private LoginPage loginPage;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchbrowser(String browserName) 
	{   
		reporter = new ExtentHtmlReporter("test-output"+File.separator + "ExtentReport"+File.separator);
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browserName.equals("Chrome"))
		{
		ChromeOptions options = new ChromeOptions();        
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
		}
		
		if(browserName.equals("Edge"))
		{
		System.setProperty("webdriver.edge.driver","H:\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("launchBrowser");
		
	}

	@BeforeClass
	public void createPOMObjects() 
	{   
		
		 loginPage = new LoginPage(driver);
		 headerPage = new HeaderPage(driver);
		 
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException, Exception, IOException 
	{
		System.out.println("loginToApplication");
		driver.get("http://localhost/login.do");
		

		String user = Utility.getDataFromExcel("Sheet1", 1, 0);
		String pass = Utility.getDataFromExcel("Sheet1", 1, 1);
		loginPage.sendUserName(user);
		loginPage.sendPassword(pass);
		loginPage.clickOnKeepMeLogin();
		loginPage.clickOnLogin();
		
		Thread.sleep(3000);
	}
	
	
	@Test
	public void verifyReportTab() 
	{
		System.out.println("verifyReportTab");
		headerPage.selectReportsHeader();
		 
	    if((driver.getCurrentUrl()).equals("http://localhost/reports/reports.do"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
	    
		 if((driver.getTitle()).equals("actiTIME - Saved Reports"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
	}
	
	
	@AfterMethod
	public void logoutOfApplication() 
	{
		System.out.println("logoutOfApplication");
		headerPage.selectLogout();
		
	}
	
	@AfterClass
	public void clearPOMObjects() 
	{
		
		loginPage  = null;
		headerPage = null;
	}
	
	@AfterTest
	public void closeBrowser() 
	{
		driver.quit();
		System.out.println("CloseBrowser");
		driver = null;
		System.gc();
	}
	
}
