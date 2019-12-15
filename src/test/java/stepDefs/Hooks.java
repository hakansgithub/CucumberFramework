package stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp() {

        WebDriver driver = Driver.driversSetUp("chrome");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)Driver.driver)
                    .getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image.png");
        }
        Driver.closeDriver();
    }
}
