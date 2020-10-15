package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class CommonPage extends DriverFactory {

    public static String fileName =(new PropertyReader().readProperty("appConfigFile"));
    public static String ConfigfileName;

    static {
        try {
            ConfigfileName = readFromCell(fileName,"SetUp",1,"fileName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CommonPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);
    }

    public void enterText(String Sheet, String rowMatch, String text) throws IOException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        UtilityMethods.waitForVisibility(element);
        element.sendKeys(text);
        System.out.println("Text enetered in element "+rowMatch+" "+ text);
    }

    public void Clickelemet(String Sheet, String rowMatch) throws IOException, InterruptedException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        UtilityMethods.wait1Seconds();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        System.out.println("Element found "+element.getText());
        UtilityMethods.waitForVisibility(element);
        UtilityMethods.scrollToWebElement(element);
        element.click();
        System.out.println("Clicked on Element "+rowMatch);
    }

    public void selectDDValue(String Sheet, String rowMatch, String text) throws IOException {
        UtilityMethods.waitForPageLoadAndPageReady();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        Select select = new Select(element);
        select.selectByVisibleText(text);
        UtilityMethods.waitForVisibility(element);
    }

}
