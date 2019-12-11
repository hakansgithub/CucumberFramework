package stepDefs;

import Pages.DressesPage;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class ViewFunction {
    DressesPage dressesPage = new DressesPage();
    Actions action = new Actions(Driver.driver);

    @Then("^Change View from Grid to list$")
    public void change_View_from_Grid_to_list() throws Throwable {
        dressesPage.grid.click();
        String actual=dressesPage.grid.getAttribute("class");
        String expected="selected";
        Assert.assertEquals(actual,expected);
    }

    @Then("^Verify it is changed$")
    public void verify_it_is_changed() throws Throwable {

    }

}
