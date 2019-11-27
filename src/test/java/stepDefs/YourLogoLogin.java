package stepDefs;

import Pages.YourLogoPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.Configuration;
import utilities.Driver;

public class YourLogoLogin {
    YourLogoPage yourLogoPage=new YourLogoPage();
    @Given("^Nagivate to sign in  page$")
    public void nagivate_to_sign_in_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("browserUrl"));
        Thread.sleep(2000);
    }
    @Given("^User click sign$")
    public void user_click_sign() throws Throwable {
       yourLogoPage.signbutton.click();
    }



    @Then("^User  in with valid credentials E mail\"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_in_with_valid_credentials_E_mail_password(String Loginemail, String loginPassword) throws Throwable {
       yourLogoPage.loginemail.sendKeys(Loginemail);
       yourLogoPage.loginPassword.sendKeys(loginPassword);

    }
    @Then("^User click sign in$")
    public void user_click_sign_in() throws Throwable {
      yourLogoPage.Sigin.click();

    }

    @Then("^Verify Home page \"([^\"]*)\"$")
    public void verify_Home_page(String Homepage) throws Throwable {
        String actual="My account - My Store";
       String expected=Driver.driver.getTitle();
        Assert.assertEquals(Homepage,actual);
    }
    @Then("^User log in with invalids credentials E mail\"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_log_in_with_invalids_credentials_E_mail_password(String loginemail, String loginPassword) throws Throwable {
        yourLogoPage.loginemail.sendKeys(loginemail);
       yourLogoPage.loginPassword.sendKeys(loginPassword);
        Thread.sleep(2000);
      yourLogoPage.Sigin.click();
    }



    @Then("^Verify gets error alert message \"([^\"]*)\"$")
    public void verifyGetsErrorAlertMessage(String alertmessage) throws Throwable {
          String actual= yourLogoPage.alertmessage.getText();
          Assert.assertTrue(actual.contains(alertmessage));
         // Assert.assertEquals(alertmessage,actual);
    }
}
