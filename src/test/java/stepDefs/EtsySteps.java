package stepDefs;

import Pages.EtsyHomePage;
import Pages.EtsyResultpage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Configuration;
import utilities.Driver;



public class EtsySteps {
    EtsyHomePage etsyHomePage = new EtsyHomePage();
    EtsyResultpage etsyResultpage = new EtsyResultpage();

    @Given("^Navigate Etsy Home page$")
    public void navigate_Etsy_Home_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("EtsyUrl"));

    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
        etsyHomePage.searchBox.click();
        etsyHomePage.searchBox.sendKeys(item + Keys.ENTER);


    }

    @Then("^Validate search message have word \"([^\"]*)\"$")
    public void validate_search_message_have_word(String item) throws Throwable {

        String actualsearcMessage = etsyResultpage.searchMessage.getText();
        Assert.assertEquals(item, actualsearcMessage);
    }

    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String department) throws Throwable {

        if (etsyHomePage.JewelryA.getText().equalsIgnoreCase(department)) {
            etsyHomePage.JewelryA.click();
        } else if (etsyHomePage.ClothingSHoes.getText().equalsIgnoreCase(department)) {
            etsyHomePage.ClothingSHoes.click();
        } else if (etsyHomePage.Homeliving.getText().equalsIgnoreCase(department)) {
            etsyHomePage.Homeliving.click();
        } else if (etsyHomePage.Wedding.getText().equalsIgnoreCase(department)) {
            etsyHomePage.Wedding.click();
        } else if (etsyHomePage.ToysE.getText().equalsIgnoreCase(department)) {
            etsyHomePage.ToysE.click();
        }


    }

    @Then("^User validate title \"([^\"]*)\"$")
    public void user_validate_title(String title) throws Throwable {
        String actualtitle = Driver.driver.getTitle();
        Assert.assertEquals(title, actualtitle);
    }

    @Then("^User search \"([^\"]*)\"$")
    public void user_search(String PHone) throws Throwable {
        etsyResultpage.searchBox.click();
        etsyResultpage.searchBox.sendKeys("wireless phone charger" + Keys.ENTER);

    }

    @Then("^User click Free Shipping$")
    public void user_click_Free_Shipping() throws Throwable {
        etsyResultpage.frees.click();
        Thread.sleep(2000);

    }

    @Then("^User verify it is has  free shipping label$")
    public void user_verify_it_is_has_free_shipping_label() throws Throwable {
        for (WebElement elemnet : etsyResultpage.allfreeshiping) {
            Assert.assertEquals("FREE shipping", elemnet.getText().trim());
        }
    }

    @When("^User click on Over Price checkbox$")
    public void user_click_on_Over_Price_checkbox() throws Throwable {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(etsyResultpage.Over1000radiobutton));
        etsyResultpage.Over1000radiobutton.click();
    }

    @Then("^User verifies all items prices are over that price$")
    public void user_verifies_all_items_prices_are_over_that_price() throws Throwable {
        for (WebElement element : etsyResultpage.resultprices) {
            String number = element.getText().replace(",", "");
            System.out.println(number);
            if (!number.isEmpty()) {
                double price = Double.parseDouble(number);
                System.out.println(price);
                Assert.assertTrue(price >= 799);
            }
        }
    }
}