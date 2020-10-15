package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class ProductDetailPage extends DriverFactory {

    public static String fileName =(new PropertyReader().readProperty("appConfigFile"));
    public static String ConfigfileName;

    static {
        try {
            ConfigfileName = readFromCell(fileName,"SetUp",1,"fileName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProductDetailPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);
    }


    public void selectProduct(String productName) throws InterruptedException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        UtilityMethods.wait1Seconds();
        WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'"+productName+"')])[1]"));
        UtilityMethods.waitForVisibility(element);
        element.click();
    }

    public void validateProductDetailPage(String Sheet, String rowMatch, String text) throws IOException, InterruptedException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        UtilityMethods.wait3Seconds();
//        UtilityMethods.wait3Seconds();
//        UtilityMethods.wait3Seconds();
        System.out.println("Validate "+text+" is appearing on Screen");
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        UtilityMethods.waitForVisibility(element);
        if(element.getText().contains(text)){
            System.out.println(element.getText());
            Assert.assertTrue(true);
        }else
            Assert.fail();
    }
}
