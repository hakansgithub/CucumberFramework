package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Plugin;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHTML-report","pretty","json:target/cucumber.json"},//provide report my test  target inside index.html
        features = "src/test/Resource/UIFeatures",// reading all features file  I need code
        glue="stepDefs",// provide where our code
        dryRun =false,// how to run true or false it is value boolean
        tags ={"@ui","@RegressionTest"}
)
public class UITestRunner {



}
