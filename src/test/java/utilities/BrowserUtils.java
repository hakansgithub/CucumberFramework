package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void hover (WebElement element, WebDriver driver){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();

    }
    // drag and drop
    /*
    This method will take the text of the webelement and return the String you need pass the elemenet
     */
    public static String getText(WebElement element){
        return element.getText();
    }
    /*
    This method will take the list of WebElement
    it will return  list of text from the webelements
     */
    public static List<String> getElementsText(List<WebElement> elements){
        List<String> TextList=new ArrayList<>();
        for (WebElement el:elements){
            if(!el.getText().isEmpty()){
                TextList.add(el.getText());
            }
        }
        return  TextList;
    }
    public  static void visibilityOfelement(WebDriver driver,WebElement element,int time){
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void clickOn(WebDriver driver1, WebElement element, int timeout){
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //clickable /// is AlertPresent ==>Homewrok
    public static void SwitchWindow(String targetTitle,WebDriver driver){
        String origin=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        for(String windows:allWindows){
            driver.switchTo().window(windows);
            if(driver.getTitle().equals(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }
}
