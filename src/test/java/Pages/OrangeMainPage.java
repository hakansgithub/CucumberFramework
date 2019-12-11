package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeMainPage {
    WebDriver driver;
    public OrangeMainPage(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="menu_admin_viewAdminModule")
    public WebElement admin;
    @FindBy(xpath = "//a[@href='saveSystemUser?userId=6']")
    public WebElement fiona;

    @FindBy(id = "btnSave")
   public WebElement editbutton;
   @FindBy(id = "systemUser_chkChangePassword")
   public WebElement changecheckbox;
   @FindBy(id = "systemUser_password")
    public WebElement newpassword;
   @FindBy(id = "systemUser_confirmPassword")
   public WebElement confirmpassword;
   @FindBy(id = "btnSave")
    public  WebElement savebutton;
   @FindBy(id="welcome")
    public  WebElement welcomebutton;
   @FindBy(xpath = "//*[@id='welcome-menu']/ul/li[2]/a")
    public WebElement logout;


   @FindBy(xpath ="//a[@id='menu_admin_viewAdminModule']")
    public  WebElement adminbuttun;
   @FindBy(xpath = "//a[@id='menu_admin_Job']")
    public  WebElement jobbutton;
   @FindBy(xpath = "//a[@id='menu_admin_viewJobTitleList']")
    public  WebElement jobtitle;
   @FindBy(xpath = "//input[@id='btnAdd']")
    public  WebElement addbuttun;
   @FindBy(xpath = "//input[@name='jobTitle[jobTitle]']")
    public  WebElement jobtitlebox;
   @FindBy(xpath = "//a[text()='IT SDETS']")
    public WebElement ITSDT;



}
