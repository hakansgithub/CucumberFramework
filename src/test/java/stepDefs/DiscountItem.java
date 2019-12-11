package stepDefs;

import Pages.DressesPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class DiscountItem {
    DressesPage dressesPage = new DressesPage();

    @Then("^User get old price and discount price$")
    public void user_get_old_price_and_discount_price() throws Throwable {
        String item = dressesPage.originprice1.getText().replace("$", "");
        String old = dressesPage.oldprice30.getText().replace("$","");
        String yuzde = dressesPage.yuzde5.getText();

        double price1 = Double.parseDouble(item);
        double price2 = Double.parseDouble(old);
       // double price3 = Double.parseDouble(yuzde);
        double total =0 ;
        double amount = (total * 30.51) / 100;
        System.out.println("sss"+old);
        String actual = String.format("%.2f", amount);
        System.out.println(actual);
        // String expected = String.format("%.2f", );
//        System.out.println("Expected total amaount is :$" + expected);
//        System.out.println("Actual total amount is : $" + actual);
//        Assert.assertEquals(expected, actual);
//    }
    }
    @Then("^User verify price$")
    public void user_verify_price() throws Throwable {

    }

}
