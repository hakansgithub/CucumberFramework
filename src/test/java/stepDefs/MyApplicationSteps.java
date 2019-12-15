package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MyApplicationPage;
import utilities.Configuration;
import utilities.Driver;
import utilities.JDBCUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplicationSteps {

    MyApplicationPage myApplicationPage = new MyApplicationPage();
    Map<String, Object> uiData = new HashMap<String, Object>();
    List<Map<String, Object>> dbData = new ArrayList<>();


    @Given("^Navigate to MyApplication$")
    public void navigate_to_MyApplication () throws Throwable {
        Driver.driver.get(Configuration.getProperties("MyApplication"));
    }

    @When("^User gets employee info for employee_id \"([^\"]*)\" from  UI$")
    public void user_gets_employee_info_for_employee_id_from_UI (String employee_id) throws Throwable {
        int indexOfRow = 0;
        for (int i = 0; i < myApplicationPage.employee_ids.size(); i++) {
            if (myApplicationPage.employee_ids.get(i).getText().equalsIgnoreCase(employee_id)) {
                indexOfRow = i;
            }
        }

        // //table//tr[4]//td

            List<WebElement> elements = Driver.driver.findElements(By.xpath("//table//tr[" + (indexOfRow + 1) + "]//td"));
            uiData.put("first_name", elements.get(0).getText());
            uiData.put("last_name", elements.get(1).getText());
            uiData.put("job_title", elements.get(3).getText());

    }

    @When("^User gets data for employee_id \"([^\"]*)\" from database$")
    public void user_gets_data_for_employee_id_from_database (String employee_id) throws Throwable {
        String query = "select first_name, last_name, job_title\n" +
                "from employees e join jobs j on\n" +
                "e.job_id = j.job_id\n" +
                "where employee_id =" + employee_id;
        JDBCUtils.establishConnection();
        dbData = JDBCUtils.runSQLQuery(query);
    }

    @Then("^Validate data is matching$")
    public void validate_data_is_matching () throws Throwable {
        Assert.assertEquals(dbData.get(0).get("FIRST_NAME"), uiData.get("first_name"));
        Assert.assertEquals(dbData.get(0).get("LAST_NAME"), uiData.get("last_name"));
        Assert.assertEquals(dbData.get(0).get("JOB_TITLE"), uiData.get("job_title"));

    }

}
