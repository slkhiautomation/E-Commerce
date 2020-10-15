package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class SearchPage extends DriverFactory {

    public static String fileName =(new PropertyReader().readProperty("appConfigFile"));
    public static String ConfigfileName;

    static {
        try {
            ConfigfileName = readFromCell(fileName,"SetUp",1,"fileName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SearchPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);
    }

    public void searchResult(String result) throws IOException, InterruptedException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        UtilityMethods.wait1Seconds();
//        UtilityMethods.wait3Seconds();
//        UtilityMethods.wait3Seconds();
//        UtilityMethods.wait3Seconds();
//        UtilityMethods.wait3Seconds();
        System.out.println("Search Result for "+result);
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,"SearchPage",1,"searchResult"));
        UtilityMethods.waitForVisibility(element);
        System.out.println("Element found and Value is "+element.getText());
        if(element.getText().contains(result)){
            Assert.assertTrue(true);
            System.out.println("Searched in List");
        }else{
            Assert.fail();
            System.out.println("Searched in List");
        }
    }
}
