package stepDefs;

import Pages.DressesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Configuration;
import utilities.Driver;


public class CalculateDress {
    DressesPage dressesPage = new DressesPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

    @Given("^Navigate to web site$")
    public void navigate_to_web_site() throws Throwable {
        Driver.driver.get(Configuration.getProperties("browserUrl"));
        Thread.sleep(2000);
    }

    @Then("^User click Dress Link$")
    public void user_click_Dress_Link() throws Throwable {
        dressesPage.dreesLink.click();
        Thread.sleep(2000);

    }

    @Then("^Select five dresses add to cart$")
    public void select_five_dresses_add_to_cart() throws Throwable {
        Actions action = new Actions(Driver.driver);
        js.executeScript("window.scrollBy(0,800)");
        action.moveToElement(dressesPage.dress1).build().perform();
        Thread.sleep(1000);
        dressesPage.addtoCart1.click();
        Thread.sleep(1000);
        dressesPage.Close1.click();
        action.moveToElement(dressesPage.dress2).build().perform();
        Thread.sleep(1000);
        dressesPage.addtoCart2.click();
        dressesPage.Close2.click();
        action.moveToElement(dressesPage.dress3).build().perform();
        Thread.sleep(1000);
        dressesPage.addtoCart3.click();
        Thread.sleep(1000);
        dressesPage.Close2.click();
        action.moveToElement(dressesPage.dress4).build().perform();
        Thread.sleep(1000);
        dressesPage.addtoCart4.click();
        Thread.sleep(1000);
        dressesPage.Close2.click();
        action.moveToElement(dressesPage.dress5).build().perform();
        Thread.sleep(1000);
        dressesPage.addtoCart5.click();
        Thread.sleep(1000);
        dressesPage.Close2.click();


    }


    @Then("^Verify If their total amaount is calculated correct$")
    public void verify_If_their_total_amaount_is_calculated_correct() throws Throwable {
        dressesPage.cart.click();
        String totalprice = dressesPage.totalAmaount.getText().replace("$", "");
        double sum = 0.0;
        double shipping = 2, totalSum = 0.0;


        for (WebElement price : dressesPage.total) {

            String number = price.getText().replace("$", "");
            if (number.length() > 0) {
                double price1 = Double.parseDouble(number);
                sum = sum + price1;
            }
        }
        totalSum = sum + shipping;
        double total = Double.parseDouble(totalprice);
        String expected = String.format("%.2f", totalSum);
        String actual = String.format("%.2f", total);
        System.out.println("Expected total amaount is :$" + expected);
        System.out.println("Actual total amount is : $" + actual);
        Assert.assertEquals(expected, actual);
    }
}
