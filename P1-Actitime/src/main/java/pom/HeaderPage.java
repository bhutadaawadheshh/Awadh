package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	@FindBy (xpath="(//div[@class='label'])[1]")
	private WebElement timeTrack;
	
	@FindBy (xpath="(//div[@class='label'])[2]")
	private WebElement tasks;
	
	@FindBy (xpath="(//div[@class='label'])[3]")
	private WebElement reports;
	
	@FindBy (xpath="(//div[@class='label'])[4]")
	private WebElement users;
	
	@FindBy (xpath="(//div[@class='label'])[5]")
	private WebElement workSchedule;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logout;
	
	
	
	public HeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectTimeTrackHeader() 
	{
		timeTrack.click();		
	}
	
	public void selectTasksHeader() 
	{
		tasks.click();		
	}
	
	public void selectReportsHeader() 
	{
		reports.click();		
	}
	
	
	public void selectUsersHeader() 
	{
		users.click();
	}
	
	public void selectWorkScheduleHeader() 
	{
		workSchedule.click();
	}
	
	public void selectLogout() 
	{
		logout.click();
	}

}
