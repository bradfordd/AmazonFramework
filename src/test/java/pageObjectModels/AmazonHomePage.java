package pageObjectModels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonHomePage extends BasePageObject {
	protected WebDriver driver;
	public AmazonHomePage(WebDriver driver) {
		super(driver);
		Assert.assertEquals(this.getCurrentUrl(), "https://www.amazon.com/ref=nav_logo");
		PageFactory.initElements(driver, this);
	}
	
	public static void navigateToAmazonHomePage(WebDriver driver) {
		driver.get("https://www.amazon.com/ref=nav_logo");
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement topSearchBar;
	
	@FindBy(id="nav-cart")
	WebElement cartButton;
	
	@FindBy(id="nav-xshop")
	WebElement navBar;
	
	@FindBy(xpath="//*[@class=\"a-carousel-viewport\"]")
	WebElement viewportCarousel;
	
	@FindBy(id="nav-orders")
	WebElement returnAndOrdersButton;
	
	@FindBy(id="nav-link-accountList")
	WebElement accountsAndListsButton;
	
	public void searchForItem(String searchItem) {
		topSearchBar.sendKeys(searchItem);
		topSearchBar.sendKeys(Keys.ENTER);
	}
}
