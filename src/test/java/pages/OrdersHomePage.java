package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrdersHomePage {

    WebDriver driver;

    public OrdersHomePage () {
        this.driver = Driver.driversSetUp("chrome");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href='Process.aspx']")
    public WebElement orderButton;

    @FindBy(xpath = "//table[@class='SampleTable']//tr")
    public List<WebElement> orderRows;
}
