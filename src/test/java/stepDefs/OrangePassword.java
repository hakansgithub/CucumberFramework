package stepDefs;

import Pages.OrangeHome;
import Pages.OrangeMainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.Configuration;
import utilities.Driver;

public class OrangePassword {
    OrangeHome orangeHome = new OrangeHome();
    OrangeMainPage orangeMainPage = new OrangeMainPage();

    @Given("^Navigate Orange Page$")
    public void navigate_Orange_Page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("orangepage"));
    }

    @And("^User login in with valid credentials username \"([^\"]*)\" password\"([^\"]*)\"$")
    public void user_login_in_with_valid_credentials_username_password(String username, String password) throws Throwable {
        orangeHome.username.sendKeys(username);
        Thread.sleep(2000);
        orangeHome.password.sendKeys(password);
        Thread.sleep(2000);
        orangeHome.login.click();
    }

    @Then("^Change password for Fiano Grace$")
    public void change_password_for_Fiano_Grace() throws Throwable {
        Thread.sleep(2000);
        orangeMainPage.admin.click();
        Thread.sleep(1000);
        orangeMainPage.fiona.click();
        orangeMainPage.editbutton.click();
        orangeMainPage.changecheckbox.click();
        orangeMainPage.newpassword.sendKeys("abcd12345");
        orangeMainPage.confirmpassword.sendKeys("abcd12345");
        orangeMainPage.savebutton.click();
    }

    @Then("^Verify it is changed  by signing in again$")
    public void verify_it_is_changed_by_signing_in_again() throws Throwable {
        Thread.sleep(2000);
        orangeMainPage.welcomebutton.click();
        Thread.sleep(2000);
        orangeMainPage.logout.click();
        orangeHome.username.sendKeys("fiona.grace");
        orangeHome.password.sendKeys("abcd12345");
        orangeHome.login.click();
        String actual = orangeMainPage.welcomebutton.getText();
        String expected = "Bienvenido Fiona";
        Assert.assertEquals(expected, actual);

    }

}
