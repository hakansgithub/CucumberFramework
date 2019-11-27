package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyHomePage {
    WebDriver driver;
    public EtsyHomePage(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="global-enhancements-search-query")
    public WebElement searchBox;
    @FindBy(xpath = "//span[@id='catnav-primary-link-10855']")
    public  WebElement JewelryA;
    @FindBy(xpath = "//span[@id='catnav-primary-link-10923']")
    public  WebElement ClothingSHoes;
    @FindBy(xpath = "//span[@id='catnav-primary-link-891']")
    public  WebElement Homeliving;
    @FindBy(xpath = "//span[@id='catnav-primary-link-10983']")
    public WebElement Wedding;
    @FindBy(id = "catnav-primary-link-11049")
    public  WebElement ToysE;


}
