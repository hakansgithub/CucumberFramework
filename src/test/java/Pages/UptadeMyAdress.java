package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UptadeMyAdress {
    WebDriver driver;
    public UptadeMyAdress(){
        this.driver= Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="email")
    public WebElement loginemail;
    @FindBy(id = "passwd")
    public WebElement passwd;
    @FindBy(id="SubmitLogin")
    public WebElement Submit;
    @FindBy(xpath = "//span[text()='My addresses']")
    public WebElement addressLink;
    @FindBy(xpath = "//a[@title='Update']")
    public WebElement updateLink;
    @FindBy(id = "address1")
    public WebElement addressInput1;
    @FindBy(id = "address2")
    public WebElement addressInput2;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "id_state")
    public WebElement selectState;
    @FindBy(id = "postcode")
    public WebElement zipCode;
    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInBtn;
    @FindBy(id = "submitAddress")
    public WebElement saveBtn;







}
