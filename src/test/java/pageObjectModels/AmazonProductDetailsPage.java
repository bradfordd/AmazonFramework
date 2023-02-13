package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductDetailsPage extends BasePageObject{
	public AmazonProductDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="productTitle")
	WebElement productTitle;
	
	public String getProductTitle() {
		return productTitle.getText();
	}
}
