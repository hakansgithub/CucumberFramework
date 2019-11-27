package stepDefs;

import Pages.YourLogoPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.openqa.selenium.support.ui.Select;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Random;


public class YourLogoDef {
  YourLogoPage yourLogoPage=new YourLogoPage();
    @Given("^Nagivate to home page$")
    public void nagivate_to_home_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("browserUrl"));
        Thread.sleep(2000);


    }

    @Then("^User click signing button$")
    public void user_click_signing_button() throws Throwable {
        Thread.sleep(2000);
       yourLogoPage.signbutton.click();

    }

    @Then("^User create by signing  with valid credentials E mail \"([^\"]*)\"$")
    public void user_create_by_signing_with_valid_credentials_E_mail(String email) throws Throwable {
        Random random=new Random(); //java faker
        int n = random.nextInt(10000);
        System.out.println(n+"@gmail.com");
       yourLogoPage.email.sendKeys(n+"@gmail.com");
      Thread.sleep(2000);

    }

    @Then("^User click Create an accaount$")
    public void user_click_Create_an_accaount() throws Throwable {
       yourLogoPage.createAccount.click();

    }

    @Then("^Fill up the new account form with the following data$")
    public void fill_up_the_new_account_form_with_the_following_data(DataTable dataTable) throws Throwable {

        List<Map<String,Object>> listOfMaps=dataTable.asMaps(String.class, Object.class);

        yourLogoPage.firstname.sendKeys(listOfMaps.get(0).get("First Name").toString());
     yourLogoPage.lastname.sendKeys(listOfMaps.get(0).get("Last Name").toString());
       yourLogoPage.password.sendKeys(listOfMaps.get(0).get("Password").toString());
      yourLogoPage.adress.sendKeys(listOfMaps.get(0).get("Adress").toString());
       yourLogoPage.city.sendKeys(listOfMaps.get(0).get("City").toString());
      yourLogoPage.state.sendKeys(listOfMaps.get(0).get("State").toString());
       yourLogoPage.zip.sendKeys(listOfMaps.get(0).get("Zip").toString());
        Select select=new Select(yourLogoPage.country);
        select.selectByVisibleText("United States");
       yourLogoPage.phone.sendKeys(listOfMaps.get(0).get("Phone No").toString());
        yourLogoPage.aliasadress.sendKeys(listOfMaps.get(0).get("Assign an address").toString());


    }

    @Then("^User clicks on Register$")
    public void user_clicks_on_Register() throws Throwable {
       yourLogoPage.register.click();

    }

}
