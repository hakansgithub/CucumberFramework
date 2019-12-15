package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MyApplicationPage {

    WebDriver driver;

    public MyApplicationPage() {
        this.driver = Driver.driversSetUp("chrome");
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//table//tr//td[3]")
    public List<WebElement> employee_ids;

}
