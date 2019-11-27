package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrdersPAge {
    WebDriver driver;
    public OrdersPAge(){
        this.driver= Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product;
    @FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
    public  WebElement quantity;
    @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement costumerName;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipcode;
    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_2")
    public  WebElement amex;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
    public  WebElement cardNum;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
    public  WebElement expDate;
    @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
    public  WebElement processButton;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(xpath = "//a[@href='Default.aspx']")
    public  WebElement orderViewButton;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaCardType;




}
