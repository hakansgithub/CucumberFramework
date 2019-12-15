package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.OrdersHomePage;
import pages.OrdersPage;

import java.util.List;
import java.util.Map;

public class AddingOrderSteps {

    OrdersHomePage ordersHomePage = new OrdersHomePage();
    OrdersPage ordersPage = new OrdersPage();
    int initialOrderCount;

    @Then("^User clicks on Order$")
    public void user_clicks_on_Order () throws Throwable {

        initialOrderCount = ordersHomePage.orderRows.size();
        ordersHomePage.orderButton.click();
    }

    @Then("^User creates new Order$")
    public void user_creates_new_Order (DataTable dataTable) throws Throwable {

        List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class);
        Select select = new Select(ordersPage.productName);
        select.selectByVisibleText(listOfMaps.get(0).get("Product Name").toString());
        Thread.sleep(1000);
        ordersPage.quantity.sendKeys(listOfMaps.get(0).get("Quantity").toString());
        Thread.sleep(1000);
        ordersPage.customerName.sendKeys(listOfMaps.get(0).get("Customer Name").toString());
        Thread.sleep(1000);
        ordersPage.street.sendKeys(listOfMaps.get(0).get("Street").toString());
        Thread.sleep(1000);
        ordersPage.city.sendKeys(listOfMaps.get(0).get("City").toString());
        Thread.sleep(1000);
        ordersPage.state.sendKeys(listOfMaps.get(0).get("State").toString());
        Thread.sleep(1000);
        ordersPage.zip.sendKeys(listOfMaps.get(0).get("Zip").toString());
        Thread.sleep(1000);
        ordersPage.cardVisa.click();
        Thread.sleep(1000);
        ordersPage.cardNumber.sendKeys(listOfMaps.get(0).get("Card Number").toString());
        Thread.sleep(1000);
        ordersPage.expirationDate.sendKeys(listOfMaps.get(0).get("Expiration Date").toString());
        Thread.sleep(1000);
        ordersPage.processButton.click();
        Thread.sleep(1000);
    }

    @Then("^User verifies Order \"([^\"]*)\" created$")
    public void user_verifies_Order_created (String isCondition) throws Throwable {

        ordersPage.ordersViewButton.click();
        int afterOrderCreated = ordersHomePage.orderRows.size();
        if (isCondition.equalsIgnoreCase("is")) {
            Assert.assertEquals(initialOrderCount + 1, afterOrderCreated);
        } else {
            Assert.assertEquals(initialOrderCount, afterOrderCreated);
        }
    }
}
