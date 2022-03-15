package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser_Pojo_Base {

	public static WebDriver launchChromeBrowser() {
		ChromeOptions options = new ChromeOptions();        
		options.addArguments("--disable-notifications");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","H:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	public static WebDriver launchEdgeBrowser() 
	{
		System.setProperty("webdriver.edge.driver","H:\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;			
	}


}
