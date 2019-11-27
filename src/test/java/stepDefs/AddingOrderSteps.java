package stepDefs;

import Pages.OrderHomePage;

import Pages.OrdersPAge;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddingOrderSteps {
OrderHomePage orderHomePage=new OrderHomePage();
OrdersPAge ordersPAge=new OrdersPAge();
int InitialOrderCount;
    @Then("^User clicks on Order$")
    public void user_clicks_on_Order() throws Throwable {
       InitialOrderCount=orderHomePage.orderRows.size();
 orderHomePage.OrderButton.click();

    }

    @Then("^User creates new order$")
    public void user_creates_new_order(DataTable dataTable) throws Throwable {
        List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class);
        Select select=new Select(ordersPAge.product);
        select.selectByVisibleText(listOfMaps.get(0).get("Product Name").toString());
        ordersPAge.quantity.sendKeys(listOfMaps.get(0).get("Quantity").toString());
        ordersPAge.costumerName.sendKeys(listOfMaps.get(0).get("Customer Name").toString());
        ordersPAge.street.sendKeys(listOfMaps.get(0).get("Street").toString());
        ordersPAge.city.sendKeys(listOfMaps.get(0).get("City").toString());
        ordersPAge.state.sendKeys(listOfMaps.get(0).get("State").toString());
        ordersPAge.zipcode.sendKeys(listOfMaps.get(0).get("Zip").toString());
        ordersPAge.cardNum.sendKeys(listOfMaps.get(0).get("Card Nr").toString());
        ordersPAge.visaCardType.click();
        Thread.sleep(2000);
        ordersPAge.expDate.sendKeys(listOfMaps.get(0).get("Expire Date").toString());
        Thread.sleep(2000);
        ordersPAge.processButton.click();

    }



    @Then("^User verifies Order \"([^\"]*)\" created$")
    public void user_verifies_Order_created(String isCondition) throws Throwable {
        Thread.sleep(2000);
        ordersPAge.orderViewButton.click();
        int afterOrderCreated = orderHomePage.orderRows.size();
        if (isCondition.equalsIgnoreCase("is")) {
            Assert.assertEquals("Initial order number is: " + InitialOrderCount + "\n" +
                    "After you created order the row number is" + afterOrderCreated, InitialOrderCount + 1, afterOrderCreated);
        } else {
            Assert.assertEquals("Initial order number is: " + InitialOrderCount + "\n" +
                            "After you created order the row number is: " + afterOrderCreated,
                    InitialOrderCount, afterOrderCreated);
        }
    }
    @Then("^User deletes \"([^\"]*)\" from table$")
    public void user_deletes_from_table(String name) throws Throwable {
       for(int i=0;i<orderHomePage.names.size();i++){
           if(orderHomePage.names.get(i).getText().equalsIgnoreCase(name)){
               orderHomePage.checkboxes.get(i).click();

           }
       }
Thread.sleep(2000);
       orderHomePage.deletebutton.click();
       Thread.sleep(2000);
    }

    @Then("^User validate that \"([^\"]*)\" is deleted$")
    public void user_validate_that_is_deleted(String name) throws Throwable {
 for(WebElement element: orderHomePage.names){
     Assert.assertFalse(element.getText().equalsIgnoreCase(name));
        }
    }



}

