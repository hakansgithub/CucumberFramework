package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import pages.EtsyResultPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

public class EtsySteps {

    EtsyHomePage etsyHomePage = new EtsyHomePage();
    EtsyResultPage etsyResultPage = new EtsyResultPage();


    @Given("^Navigate Etsy Homepage$")
    public void navigate_Etsy_Homepage () throws Throwable {

        Driver.driver.get(Configuration.getProperties("etsyUrl"));

    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for (String item) throws Throwable {

        etsyHomePage.searchBox.sendKeys(item + Keys.ENTER);
    }

    @Then("^validate search message have the word \"([^\"]*)\"$")
    public void validate_search_message_have_the_word (String item) throws Throwable {

        String actualSearchMessage = etsyResultPage.searchMessage.getText();
        Assert.assertEquals(item, actualSearchMessage);
    }

    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on (String department) throws Throwable {

        if (etsyHomePage.JeweleryAccessories.getText().equalsIgnoreCase(department)) {
            etsyHomePage.JeweleryAccessories.click();
        } else if (etsyHomePage.clothesAndShoes.getText().equalsIgnoreCase(department)) {
            etsyHomePage.clothesAndShoes.click();
        } else if (etsyHomePage.homeAndLiving.getText().equalsIgnoreCase(department)) {
            etsyHomePage.homeAndLiving.click();
        } else if (etsyHomePage.toysAndEntertainment.getText().equalsIgnoreCase(department)) {
            etsyHomePage.toysAndEntertainment.click();
        } else if (etsyHomePage.weddingAndParty.getText().equalsIgnoreCase(department)) {
            etsyHomePage.weddingAndParty.click();
        }
    }

    @Then("^User validate the title \"([^\"]*)\"$")
    public void user_validate_the_title (String title) throws Throwable {

        String actualTitle = Driver.driver.getTitle();
        Assert.assertEquals(title, actualTitle);
    }

    @When("^User clicks on Free Shipping checkbox$")
    public void user_clicks_on_Free_Shipping_checkbox () throws Throwable {

        etsyResultPage.freeShippingCheckbox.click();
        Thread.sleep(5000);

    }

    @Then("^Verify all results that have \"([^\"]*)\" label$")
    public void verify_all_results_that_have_label (String label) throws Throwable {

        for (WebElement element : etsyResultPage.freeShippingLabels) {
            Assert.assertEquals(label, element.getText().trim());
        }

    }

}
