package stepDefs;

import Pages.UptadeMyAdress;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class UpdatetAdress {
    UptadeMyAdress uptadeMyAdress=new UptadeMyAdress();

    @Given("^Navigate to login page$")
    public void navigate_to_login_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("browserUrl"));
        Thread.sleep(2000);

    }

    @Then("^User to sign in button$")
    public void user_to_sign_in_button() throws Throwable {
        Thread.sleep(2000);
     uptadeMyAdress.signInBtn.click();

    }

    @Then("^User signs in with valid credentials email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_signs_in_with_valid_credentials_email_and_password(String  loginemail, String passwd) throws Throwable {
        uptadeMyAdress.loginemail.sendKeys(loginemail);
        uptadeMyAdress.passwd.sendKeys(passwd);
        uptadeMyAdress.Submit.click();

    }

    @Then("^Click on My Addresses link and press update button$")
    public void click_on_My_Addresses_link_and_press_update_button() throws Throwable {

   uptadeMyAdress.addressLink.click();
   uptadeMyAdress.updateLink.click();
    }

    @Then("^User edits his Address information$")
    public void user_edits_his_Address_information(DataTable dataTable) throws Throwable {


        List<Map<String,Object>> listOfMaps=dataTable.asMaps(String.class, Object.class);
        uptadeMyAdress.addressInput1.clear();
       uptadeMyAdress.addressInput1.sendKeys(listOfMaps.get(0).get("Adress").toString());
       Thread.sleep(2000);
        uptadeMyAdress.city.clear();
       uptadeMyAdress.city.sendKeys(listOfMaps.get(0).get("City").toString());
        Thread.sleep(2000);
      uptadeMyAdress.selectState.sendKeys(listOfMaps.get(0).get("State").toString());
        Select select=new Select(uptadeMyAdress.selectState);
        select.selectByVisibleText("New York");
        uptadeMyAdress.zipCode.clear();
        uptadeMyAdress.zipCode.sendKeys(listOfMaps.get(0).get("Zip").toString());
        Thread.sleep(2000);
    }

    @Then("^Verify the Address is updated$")
    public void verify_the_Address_is_updated() throws Throwable {
        Thread.sleep(2000);
        String actual=Driver.driver.getTitle();
        String expected="Address - My Store";
        Assert.assertEquals(expected,actual);

    }

}
