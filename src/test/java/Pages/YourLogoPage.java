package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class YourLogoPage {
    WebDriver driver;
    public YourLogoPage(){
        this.driver= Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }
  @FindBy(xpath ="//a[@class='login']")
    public WebElement signbutton;
    @FindBy(id ="email_create")
    public WebElement email;
    @FindBy(id="SubmitCreate")
    public WebElement createAccount;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstname;
    @FindBy(xpath="//input[@id='customer_lastname']")
    public WebElement lastname;
    @FindBy(xpath= "//input[@id='passwd']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='address1']")
    public WebElement adress;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "id_state")
    public WebElement state;
    @FindBy(id = "postcode")
    public WebElement zip;
    @FindBy(xpath = "//select[@id='id_country']")
    public WebElement country;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement phone;
    @FindBy(xpath = "//input[@id='alias']")
    public WebElement aliasadress;
    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement register;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginemail;
    @FindBy(id = "passwd")
    public  WebElement loginPassword;
    @FindBy(id="SubmitLogin")
    public WebElement Sigin;
    @FindBy(xpath = "//div[@id='center_column']/div[1]")
    public WebElement alertmessage;

}
