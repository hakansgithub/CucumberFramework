package stepDefs;

import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Configuration;
import utilities.Driver;

public class VerifyLog {


    LoginPage loginPage=new LoginPage();
    @Given("^Nagivate to login page$")
    public void nagivate_to_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      Driver.driver.get(Configuration.getProperties("browserUrl1"));
       Thread.sleep(2000);

    }

    @Then("^User logs in with valid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_credentials_username_password(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       loginPage.username.sendKeys(username);
       loginPage.password.sendKeys(password);
       loginPage.loginButton.click();
    }

    @Then("^Verify user is in Homepage$")
    public void verify_user_is_in_Homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualtitle=Driver.driver.getTitle();
        String expecttitle="Web Orders";
        Assert.assertEquals(expecttitle,actualtitle);

    }
    @Then("^User logs in with invalid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_invalid_credentials_username_password(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      loginPage.username.sendKeys(username);
      loginPage.password.sendKeys(password);
      loginPage.loginButton.click();
    }

    @Then("^Verify user gets error message\"([^\"]*)\"$")
    public void verify_user_gets_error_message(String errorMessage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      String actual=loginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,actual);
    }


}
