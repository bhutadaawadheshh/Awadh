package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy (xpath="//input[@name='username']")
	private WebElement userName ;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password ;
	
	@FindBy (xpath="//input[@name='remember']")
	private WebElement keepMeLoggedInCheckbox ;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement login ;
	
	private WebDriver driver;   //global variable declare
	private WebDriverWait wait;  //global variable declare
	private Actions act;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;   //global variable initialize
		wait = new WebDriverWait(driver,20);  //global variable initialize
	    act = new Actions(driver);
		
	}
	
	public void sendUserName(String user) 
	{
	  wait.until(ExpectedConditions.visibilityOf(userName));
      userName.sendKeys(user);		
	}
	
	public void sendPassword(String pass) 
	{
	  wait = new WebDriverWait(driver,30); //waiting time changed
	  wait.until(ExpectedConditions.visibilityOf(password));
      password.sendKeys(pass);		
	}
	
	public void clickOnKeepMeLogin() 
	{    
	    //Select s = new Select(webelement);
		if(!(keepMeLoggedInCheckbox.isSelected())) 
		{
		keepMeLoggedInCheckbox.click();
		}
		else 
		{
			System.out.println("Checkbox already selected");
		}
	}
	
	public void clickOnLogin() 
	{
      act.moveToElement(login).click().build().perform();
	}
	
	//---------------------------------------------------------------------------------------------------------------
	/*
	public void loginToApplication() 
	{
      userName.sendKeys("admin");
      password.sendKeys("manager");	
      if(!(keepMeLoggedInCheckbox.isSelected())) 
		{
		keepMeLoggedInCheckbox.click();
		}
		else 
		{
			System.out.println("Check box already selected");
		}
      login.click();
     
	}
    */
}
