package stepDefs;

import Pages.DressesPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

public class ChooseColor {

    DressesPage dressesPage = new DressesPage();
    Actions action = new Actions(Driver.driver);

    @Then("^choose Blue color$")
    public void choose_Blue_color() throws Throwable {
        dressesPage.dreesLink.click();
        action.moveToElement(dressesPage.dress3).build().perform();
        dressesPage.bluecolor.click();
        Thread.sleep(2000);
        String actual = "http://automationpractice.com/index.php?id_product=5&controller=product#/size-s/color-blue";
        String expected = Driver.driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);

    }
}