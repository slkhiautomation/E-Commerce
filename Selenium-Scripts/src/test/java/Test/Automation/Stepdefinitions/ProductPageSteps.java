package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.ProductPage;
import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.ExcelFileManager;
import cucumber.api.java.en.And;

public class ProductPageSteps extends DriverFactory {
    private ProductPage productpage;

    public ProductPageSteps() throws Exception{
        productpage = new ProductPage(driver);
    }

    @And("^User Add product to the cart$")
    public void user_add_product_to_the_cart() throws Exception{

        //Reading xpath file information from setup sheet
        String xpathFileName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"fileName");
        String xpathSheetName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"sheetName");
        int xpathRowNumber = Integer.parseInt(ExcelFileManager.readFromCell("Testdata","SetUp",1,"rowToMatch"));

        //Getting xpath from xpathfile
        String addToCartXpath = ExcelFileManager.readFromCell(xpathFileName,xpathSheetName,xpathRowNumber,"addToCartField");

        productpage.clickAddToCart(addToCartXpath);
    }

    @And("^User Open Cart$")
    public void user_open_cart() throws Exception{

        String xpathFileName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"fileName");
        String xpathSheetName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"sheetName");
        int xpathRowNumber = Integer.parseInt(ExcelFileManager.readFromCell("Testdata","SetUp",1,"rowToMatch"));

        //Getting xpath from xpathfile
        String addToCartXpath = ExcelFileManager.readFromCell(xpathFileName,xpathSheetName,xpathRowNumber,"cartField");

        productpage.openCart(addToCartXpath);
    }

}