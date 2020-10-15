package Test.Automation.Stepdefinitions;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.ExcelFileManager;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import cucumber.api.java.en.Given;


public class StartingSteps extends DriverFactory {

    @Given("^Navigate to Application$")
    public void navigate_to_Application() throws Throwable {
        UtilityMethods.deleteCookies();
//        String URL = ExcelFileManager.readFromCell("Testdata","SetUp",1,"URL");
        String URL = new PropertyReader().readProperty("URL");
        driver.manage().window().maximize();
        driver.get(URL);
        UtilityMethods.waitForPageLoadAndPageReady();
    }

    @Given("^Navigate to Web Application$")
    public void navigate_to_web_Application() throws Throwable {
        UtilityMethods.deleteCookies();
        String URL = ExcelFileManager.readFromCell("Testdata","SetUp",1,"URL");
        //String URL = new PropertyReader().readProperty("URL");
        driver.manage().window().maximize();
        driver.get(URL);
        UtilityMethods.waitForPageLoadAndPageReady();

    }
}
