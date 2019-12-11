package stepDefs;

import Pages.OrangeMainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

public class OrangePageJObTitle {
    OrangeMainPage orangeMainPage = new OrangeMainPage();
    Actions actions=new Actions(Driver.driver);
    @Given("^User click Job title and add IT SDET job$")
    public void user_click_Job_title_and_add_IT_SDET_job() throws Throwable {
     orangeMainPage.admin.click();

Thread.sleep(2000);

        actions.moveToElement(orangeMainPage.jobbutton).build().perform();
Thread.sleep(2000);
        orangeMainPage.jobtitle.click();
        orangeMainPage.addbuttun.click();
        Thread.sleep(2000);
        orangeMainPage.jobtitlebox.sendKeys("IT SDETS");
        orangeMainPage.savebutton.click();
    }

    @Then("^User job Title section and added IT SDET job and verify it is added\\.$")
    public void user_job_Title_section_and_added_IT_SDET_job_and_verify_it_is_added() throws Throwable {
      String actual=orangeMainPage.ITSDT.getText();
     String expected="IT SDETS";
        Assert.assertEquals(actual,expected);
    }

}
