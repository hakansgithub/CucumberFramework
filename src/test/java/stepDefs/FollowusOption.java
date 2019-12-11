package stepDefs;

import Pages.DressesPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.BrowserUtils;
import utilities.Driver;

public class FollowusOption {

    DressesPage dressesPage = new DressesPage();
    @Then("^User Clickes Youtube icon it is taking Selenium Framework Youtube page$")
    public void user_Clickes_Youtube_icon_it_is_taking_Selenium_Framework_Youtube_page() throws Throwable {
     dressesPage.youtube.click();
        String youTubeTitle="Selenium Framework - YouTube";
        BrowserUtils.SwitchWindow(youTubeTitle,Driver.driver);
        Assert.assertEquals(youTubeTitle, Driver.driver.getTitle());
        Thread.sleep(2000);
    }

    @Then("^User Clickes facebook icon it is taking Facebook page$")
    public void user_Clickes_facebook_icon_it_is_taking_Facebook_page() throws Throwable {
      dressesPage.facebook.click();
        String facebookTitle="Selenium Framework Public Group | Facebook";
        BrowserUtils.SwitchWindow(facebookTitle,Driver.driver);
        Assert.assertEquals(facebookTitle, Driver.driver.getTitle());
    }

    @Then("^Verify  page$")
    public void verify_page() throws Throwable {

    }
}
