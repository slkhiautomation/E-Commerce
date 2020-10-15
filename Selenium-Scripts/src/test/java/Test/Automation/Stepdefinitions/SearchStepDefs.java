package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.CommonPage;
import Test.Automation.Pages.SearchPage;
import Test.Automation.Utils.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class SearchStepDefs extends DriverFactory {

    private SearchPage searchPage;
    private CommonPage commonPage;

    public SearchStepDefs() throws Exception {
        searchPage = new SearchPage(driver);
        commonPage = new CommonPage(driver);
    }

    @When("^user search the product$")
    public void user_search_the_product() throws Throwable {
        commonPage.enterText("SearchPage","searchBar",
                readFromCell("TestData","SearchPage",1,"Searchproduct")
        );
    }

    @When("^Click on search button$")
    public void click_on_search_button() throws Throwable {
        commonPage.Clickelemet("SearchPage","searchButton");
    }

    @Then("^user able to see searched product in result$")
    public void user_able_to_see_searched_product_in_result() throws Throwable {
        searchPage.searchResult(
                readFromCell("TestData","SearchPage",1,"searchResult")
        );
    }
}
