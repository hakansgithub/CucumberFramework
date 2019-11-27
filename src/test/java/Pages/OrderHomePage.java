package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrderHomePage {
    WebDriver driver;
   public OrderHomePage(){
        this.driver= Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@href='Process.aspx']")
    public WebElement OrderButton;
   @FindBy(xpath = "//table[@class='SampleTable']//tr")
    public List<WebElement> orderRows;
    @FindBy(xpath ="//table[@class='SampleTable']//tr//td[2]")
    public List<WebElement> names;
    @FindBy(xpath = "//table[@class='SampleTable']//tr//td[1]")
    public  List<WebElement> checkboxes;
    @FindBy(id="ctl00_MainContent_btnDelete")
    public  WebElement deletebutton;


}
