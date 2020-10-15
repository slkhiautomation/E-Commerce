package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.CheckOutPage;
import Test.Automation.Pages.CommonPage;
import Test.Automation.Pages.ProductDetailPage;
import Test.Automation.Utils.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class CheckOutStepDefs extends DriverFactory {

    private CheckOutPage checkOut;
    private CommonPage commonPage;
    private ProductDetailPage PDP;

    public CheckOutStepDefs() throws Exception {
        checkOut = new CheckOutPage(driver);
        commonPage = new CommonPage(driver);
        PDP = new ProductDetailPage(driver);
    }

    @Given("^user click on cart$")
    public void user_click_on_cart() throws Throwable {
        commonPage.Clickelemet("Checkout","shoopingCart");
    }

    @Given("^proceed to checkout$")
    public void proceed_to_checkout() throws Throwable {
        commonPage.Clickelemet("Checkout","checkOut");
    }

    @Then("^assert that Guest CheckOut available$")
    public void assert_that_Guest_CheckOut_available() throws Throwable {
        checkOut.vlidateButtonavailibility("Checkout","guestCheckOut");
    }

    @Then("^enter zipCode$")
    public void enter_zipCode() throws Throwable {
        commonPage.enterText("Checkout","zipCode",
                readFromCell("Testdata","checkOut",1,"zipCode")
                );
    }

    @Given("^proceed to Guest Checkout$")
    public void proceed_to_Guest_Checkout() throws Throwable {
        commonPage.Clickelemet("Checkout","guestCheckOut");
    }


    @Then("^click on CheckOut$")
    public void click_on_CheckOut() throws Throwable {
        commonPage.Clickelemet("Checkout","check-Out");
    }

    @Then("^assert navigated to Guest Checkout page$")
    public void assert_navigated_to_Guest_Checkout_page() throws Throwable {
        PDP.validateProductDetailPage("Checkout","guestChekOut",
                readFromCell("TestData","checkOut",1,"GuestCheckOutPage")
        );
    }

    @Given("^user enter shipping information$")
    public void user_enter_shipping_information() throws Throwable {
        commonPage.enterText("ShipperForm","firstName",
                readFromCell("TestData","ShipperForm",1,"firstName")
                );
        commonPage.enterText("ShipperForm","lastName",
                readFromCell("TestData","ShipperForm",1,"lastName")
        );
        commonPage.enterText("ShipperForm","address",
                readFromCell("TestData","ShipperForm",1,"address")
        );
        commonPage.enterText("ShipperForm","UnitNumber",
                readFromCell("TestData","ShipperForm",1,"UnitNumber")
        );
        commonPage.enterText("ShipperForm","City",
                readFromCell("TestData","ShipperForm",1,"City")
        );
        commonPage.enterText("ShipperForm","State",
                readFromCell("TestData","ShipperForm",1,"State")
        );
        commonPage.enterText("ShipperForm","ZipCode",
                readFromCell("TestData","checkOut",1,"zipCode")
        );
        commonPage.enterText("ShipperForm","email",
                readFromCell("TestData","ShipperForm",1,"email")
        );
        commonPage.enterText("ShipperForm","phone",
                readFromCell("TestData","ShipperForm",1,"phone")
        );
        commonPage.Clickelemet("ShipperForm","submit");
    }
}
