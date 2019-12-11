package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHome {
    WebDriver driver;
    public OrangeHome(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="txtUsername")
    public WebElement username;
    @FindBy (id ="txtPassword")
    public WebElement password;
    @FindBy (id = "btnLogin")
    public WebElement login;
}
