package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.ExcelFileManager;
import Test.Automation.Utils.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends DriverFactory {


    public ProductPage(WebDriver driver) throws Exception{
        PageFactory.initElements(driver,this);

    }

    public void clickAddToCart(String addtoCartXpath) throws Exception{
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.elementClick(addtoCartXpath);
        //addToCart.click();
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.wait3Seconds();
    }

    public void openCart(String cartXpath) throws Exception{
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.elementClick(cartXpath);
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.wait3Seconds();

    }
}
