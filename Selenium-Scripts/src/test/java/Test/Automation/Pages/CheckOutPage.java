package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class CheckOutPage extends DriverFactory {

    public static String fileName =(new PropertyReader().readProperty("appConfigFile"));
    public static String ConfigfileName;

    static {
        try {
            ConfigfileName = readFromCell(fileName,"SetUp",1,"fileName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CheckOutPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);
    }

    public void vlidateButtonavailibility(String Sheet, String rowMatch) throws IOException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        boolean result = element.isDisplayed();
        if(result){
            Assert.assertTrue(result);
        }else
            Assert.fail();
    }
}
