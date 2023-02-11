package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	WebDriver driver;
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	
}
