package pageObjectModels;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchResultsPage extends BasePageObject {
	public AmazonSearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]")
	WebElement searchResultsDisplay;
	
	@FindBy(xpath="//*[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
	List<WebElement> searchResults;
	
	public void verifyCorrectSearch(String searchText) {
		Assert.assertTrue("Incorrect item search on Amazon Search Results Page", searchResultsDisplay.getText().contains(searchText));
	}
	
	public int getSearchResultsPerPage() {
		return searchResults.size();
	}
	
	public String getItemName(int i) {
		return searchResults.get(i).getText();
	}
	
	public void selectItemFromSearchResults(int i) {
		if (searchResults.size() - 1 < i) {
			Assert.assertTrue("No items found on Amazon Search Page",false);
		}
		searchResults.get(i).click();
	}
	
}
