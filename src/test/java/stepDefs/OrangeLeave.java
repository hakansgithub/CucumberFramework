package stepDefs;

import Pages.OrangeLeaveSection;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class OrangeLeave {
OrangeLeaveSection orangeLeaveSection=new OrangeLeaveSection();

    @Then("^User click Leave section and Choose Linda Anderson’s number leave days$")
    public void user_click_Leave_section_and_Choose_Linda_Anderson_s_number_leave_days() throws Throwable {
      orangeLeaveSection.leaveButton.click();
      Thread.sleep(2000);

    }

    @Then("^User verify Linda Anderson’s number leave days properly calculated by going to details of leave and counting the day$")
    public void user_verify_Linda_Anderson_s_number_leave_days_properly_calculated_by_going_to_details_of_leave_and_counting_the_day() throws Throwable {

        Double sum = 0.0;
      Double expected=Double.parseDouble(orangeLeaveSection.numberofDays.getText());

        System.out.println(expected);
Thread.sleep(2000);
          orangeLeaveSection.LindaDate.click();
Thread.sleep(2000);
        for (WebElement price : orangeLeaveSection.Hours) {
            if (price.getText().length() == 4) {
                String hour = price.getText();
                Double price1 = Double.parseDouble(hour);
                sum = sum + price1;
            }
        }
            Double result=sum/8.00;

            Assert.assertEquals(expected,result);
        }


    }