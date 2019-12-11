package stepDefs;

import Pages.MyApplicationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Configuration;
import utilities.Driver;
import utilities.JDBCUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplicationSteps {
MyApplicationPage myApplicationPage=new MyApplicationPage();
Map<String,Object>uiData=new HashMap<String, Object>();
List<Map<String,Object>>dbData=new ArrayList<>();

    @Given("^Navigate MyApplication$")
    public void navigate_MyApplication() throws Throwable {
        Driver.driver.get(Configuration.getProperties("Myapplication"));
    }

    @When("^User gets employee info for employee_id\"([^\"]*)\" from UI$")
    public void user_gets_employee_info_for_employee_id_from_UI(String employee_id) throws Throwable {
        int indexofRow=0;
        for(int i=0;i<myApplicationPage.listtable.size();i++){
            if(myApplicationPage.listtable.get(i).getText().equalsIgnoreCase(employee_id)){

                indexofRow=i;
            }
        }

            List<WebElement>elements=Driver.driver.findElements(By.xpath("//table//tr["+(indexofRow+1)+"]//td"));
        uiData.put("first_name",elements.get(0).getText());
        uiData.put("last_name",elements.get(1).getText());
        uiData.put("job_title",elements.get(3).getText());
    }

    @When("^User gets data for employee_id\"([^\"]*)\" from database$")
    public void user_gets_data_for_employee_id_from_database(String employee_id) throws Throwable {

     String query="select e.first_name, e.last_name, j.job_title\n" +
             "from employees e join jobs j on\n" +
             "e.job_id=j.job_id\n" +
             "where employee_id="+employee_id;
        JDBCUtils.establishConnecttion();
        dbData=JDBCUtils.runSQLQuery(query);

    }

    @Then("^Validate data are matching$")
    public void validate_data_are_matching() throws Throwable {
        Assert.assertEquals(dbData.get(0).get("FIRST_NAME"),uiData.get("first_name"));
        Assert.assertEquals(dbData.get(0).get("LAST_NAME"),uiData.get("last_name"));
        Assert.assertEquals(dbData.get(0).get("JOB_TITLE"),uiData.get("job_title"));

    }



}
