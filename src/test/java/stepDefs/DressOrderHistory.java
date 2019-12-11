package stepDefs;

import Pages.DressesPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class DressOrderHistory {
    DressesPage dressesPage = new DressesPage();
    Actions action = new Actions(Driver.driver);
    JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

    @Then("^Select summer dresses add to cart$")
    public void select_summer_dresses_add_to_cart() throws Throwable {
        action.moveToElement(dressesPage.dreesLink).build().perform();
        Thread.sleep(1000);
       dressesPage.summerdress.click();
    }

    @Then("^User verify summer dress on your Order History$")
    public void user_verify_summer_dress_on_your_Order_History() throws Throwable {
        js.executeScript("window.scrollBy(0,800)");
        action.moveToElement(dressesPage.summerdress1).build().perform();
        Thread.sleep(1000);
       String actual = dressesPage.summerdresspricce.getText();

        Assert.assertTrue(actual,true);
    }

}
