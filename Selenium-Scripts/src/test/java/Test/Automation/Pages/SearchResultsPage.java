package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.ExcelFileManager;
import Test.Automation.Utils.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends DriverFactory {


    public SearchResultsPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);

    }

    public void clickOnProduct(String productXpath) throws Exception{
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.elementClick(productXpath);
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.wait3Seconds();

    }
}
