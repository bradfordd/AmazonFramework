package StepImplementations;

import org.junit.Assert;
import org.testng.annotations.Test;

import automationUtils.RunWeb;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjectModels.AmazonHomePage;
import pageObjectModels.AmazonProductDetailsPage;
import pageObjectModels.AmazonSearchResultsPage;

public class StepDefinitions extends RunWeb{
	AmazonHomePage h;
	AmazonSearchResultsPage s;
	AmazonProductDetailsPage p;
	@Given("User Navigates to Amazon HomePage without being logging in")
	public void Navigate_To_Amazon_HomePage() {
		initializeWebDriver("Chrome");
		AmazonHomePage.navigateToAmazonHomePage(driver);
	}
	@Given("User Searches For (.+)$")
	public void Search_For_Item(String item) {
		h = new AmazonHomePage(driver);
		h.searchForItem(item);
	}
	@And("User is navigated to (.+) search results page, selects first item on Search Page$")
	public void Select_First_item(String item) {
		s = new AmazonSearchResultsPage(driver);
		s.verifyCorrectSearch(item);
		Assert.assertTrue("No search results found on page.", s.getSearchResultsPerPage() > 0);
		String itemName = s.getItemName(0);
		s.selectItemFromSearchResults(0);
	}
	
	@Then("Product details Page Corresponding with selected entry is displayed")
	public void PDP_Of_Selected_Result() {
		p = new AmazonProductDetailsPage(driver);
	}
	
	@After
	public void afterScenario() {
	  driver.close();
	}
}
