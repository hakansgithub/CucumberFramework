package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrangeLeaveSection {
    WebDriver driver;
    public OrangeLeaveSection(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="menu_leave_viewLeaveModule")
    public WebElement leaveButton;
    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr[1]/td[1]/a")
    public WebElement LindaDate;
    @FindBy(xpath = "//td[contains(text(),'10.00')]")
    public WebElement numberofDays;
    @FindBy(xpath = "//*[@class='table hover']//tr//td[4]")
    public List<WebElement>Hours;
   @FindBy(xpath = "//*[@id='resultTable']/thead/tr/th[4]/span")
    public  List<WebElement> DurationHours;

//    @FindBy(xpath = "//span[text()='Duration (Hours)']")
//    public  List<WebElement> DurationHours;

}
