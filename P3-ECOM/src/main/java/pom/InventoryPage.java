package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {


	@FindBy (xpath="//select[@class='product_sort_container']")
	private WebElement nameZ_A ;
	
	@FindBy (xpath="(//div[@id='root']//button)[3]")
	private WebElement addToCart ;
	
	@FindBy (xpath="//a[@class='shopping_cart_link']")
	private WebElement cart ;
	
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void sortByProduct()
	{
		nameZ_A.click();
	}

	public void addProductToCart()
	{
		addToCart.click();
	}
	public void clickOnCart()
	{
		cart.click();
	}
}
