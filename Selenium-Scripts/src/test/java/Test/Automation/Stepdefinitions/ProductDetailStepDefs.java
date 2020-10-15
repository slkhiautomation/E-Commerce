package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.CommonPage;
import Test.Automation.Pages.ProductDetailPage;
import Test.Automation.Utils.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class ProductDetailStepDefs extends DriverFactory {
    private ProductDetailPage PDP;
    private CommonPage commonPage;

    public ProductDetailStepDefs() throws Exception {
        PDP = new ProductDetailPage(driver);
        commonPage = new CommonPage(driver);
    }

    @Given("^user select product$")
    public void user_select_product() throws Throwable {
        PDP.selectProduct(
                readFromCell("TestData","Products",1,"selectProduct")
        );
    }

    @Then("^validate the product details$")
    public void validate_the_product_details() throws Throwable {
        PDP.validateProductDetailPage("PDP","productName",
                readFromCell("TestData","Products",1,"selectProduct")
                );
//        PDP.validateProductDetailPage("PDP","productPrice",
//                readFromCell("TestData","Products",1,"productPrice")
//        );
        PDP.validateProductDetailPage("PDP","styleNo",
                readFromCell("TestData","Products",1,"styleNo")
        );
    }

    @Given("^user Add product to Cart$")
    public void user_Add_product_to_Cart() throws Throwable {
        commonPage.Clickelemet("PDP","AddtoCart");
    }

    @Then("^assert product has been added$")
    public void assert_product_has_been_added() throws Throwable {
        PDP.validateProductDetailPage("PDP","productCount",
                readFromCell("TestData","Products",1,"oneProduct")
        );
    }
}
