package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.SearchResultsPage;
import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.ExcelFileManager;
import cucumber.api.java.en.And;

public class SearchResultsPageSteps extends DriverFactory {
    private SearchResultsPage searchResultsPage;

    public SearchResultsPageSteps() throws Exception {
        searchResultsPage = new SearchResultsPage(driver);
    }

    @And("^User Clicks on the product$")
    public void user_clicks_on_the_product() throws Throwable{

        //Reading xpath file information from setup sheet
        String xpathFileName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"fileName");
        String xpathSheetName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"sheetName");
        int xpathRowNumber = Integer.parseInt(ExcelFileManager.readFromCell("Testdata","SetUp",1,"rowToMatch"));

        //Getting productXpath from xpath file
        String productXpath = ExcelFileManager.readFromCell(xpathFileName,xpathSheetName,xpathRowNumber,"productField");


        searchResultsPage.clickOnProduct(productXpath);
    }
}
