package test;

import java.util.concurrent.TimeUnit;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Browser_Pojo_Base;
import pom.HeaderPage;
import pom.LoginPage;
import utils.Utility;

public class VerifyApplicationHeader extends  Browser_Pojo_Base {
	
	private WebDriver driver;
	private HeaderPage headerPage;
	private LoginPage loginPage;
	SoftAssert softassert;
	String testID;
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
		  driver = launchChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
		  driver = launchEdgeBrowser(); 
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
	public void loginToApplication() throws Exception  
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
	
	@Test  (priority=3)
	public void verifyUserTab() 
	{   
		testID ="XY003";
		System.out.println("verifyUserTab");
		headerPage.selectUsersHeader();
		
		softassert = new SoftAssert();
		softassert.assertEquals(driver.getCurrentUrl(),"http://localhost/administration/userlist.do");
		/* 
	    if((driver.getCurrentUrl()).equals("http://localhost/administration/userlist.do"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
		 */
		softassert.assertEquals(driver.getTitle(), "actiTIME - User List"); //soft assert
		softassert.assertAll();
	}
	
	@Test  (priority=2)
	public void verifyReportTab() 
	{
		testID ="XY004";
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
	
	@Test (priority=0)
	public void verifyTimeTrackTab() 
	{
		testID ="XY005";
		System.out.println("verifyTimeTrackTab");
		headerPage.selectTimeTrackHeader();
		 
	    if((driver.getCurrentUrl()).equals("http://localhost/user/submit_tt.do"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
		 
		 if((driver.getTitle()).equals("actiTIME - Enter Time-Track"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
	}
	
	@Test  (priority=1)
	public void verifyTasksTab() 
	{
		testID ="XY006";
		System.out.println("verifyTasksTab");
		headerPage.selectTasksHeader();
		Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/tasks/otasklist.do"); //hard assert
		 
	    if((driver.getCurrentUrl()).equals("http://localhost/tasks/otasklist.do"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
		 
		 if((driver.getTitle()).equals("actiTIME - Open Tasks"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
	}
	
	@Test  (priority=4, invocationCount = 3)
	public void verifyWorkScheduleTab() 
	{
		testID ="XY007";
		System.out.println("verifyWorkScheduleTab");
		headerPage.selectWorkScheduleHeader();
		 
	    if((driver.getCurrentUrl()).equals("http://localhost/administration/workingdays"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
	    
		 if((driver.getTitle()).equals("actiTIME - Corporate Schedule"))
	     {
	    	System.out.println("PASS");
	     }
	    else
	     {
	    	System.out.println("FAIL");
         }
		 Assert.fail();
	}
	
	
	@AfterMethod
	public void logoutOfApplication(ITestResult result) throws Exception 
	{
		if(ITestResult.FAILURE == result.getStatus())
			{
			Utility.screenshot(driver, testID);
			}
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
