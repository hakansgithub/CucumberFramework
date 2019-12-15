package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHTML-report", "pretty", "json:target/cucumber.json"},
        features= {"src/test/resources/uiFeatures", "src/test/resources/dbFeatures"}, // reading all features file  I need code
        glue = "stepDefs", // provide where our code
        dryRun = false, // how to run true or false it is value boolean
        tags = {"@TECTC-110"}
)
public class UITestRunner {

}