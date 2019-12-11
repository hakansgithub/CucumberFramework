$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("OrangeHomePage.feature");
formatter.feature({
  "line": 2,
  "name": "HR Management Application",
  "description": "",
  "id": "hr-management-application",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ProjectOrange"
    }
  ]
});
formatter.before({
  "duration": 3385435388,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Login to application and go to Leave section and verify Linda Anderson’s number leave days",
  "description": "",
  "id": "hr-management-application;login-to-application-and-go-to-leave-section-and-verify-linda-anderson’s-number-leave-days",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@ProjectOrange1"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "Navigate Orange Page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User login in with valid credentials username \"Admin\" password\"admin123\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User click Leave section and Choose Linda Anderson’s number leave days",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User verify Linda Anderson’s number leave days properly calculated by going to details of leave and counting the day",
  "keyword": "And "
});
formatter.match({
  "location": "OrangePassword.navigate_Orange_Page()"
});
formatter.result({
  "duration": 14662662038,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Admin",
      "offset": 47
    },
    {
      "val": "admin123",
      "offset": 63
    }
  ],
  "location": "OrangePassword.user_login_in_with_valid_credentials_username_password(String,String)"
});
formatter.result({
  "duration": 14268043993,
  "status": "passed"
});
formatter.match({
  "location": "OrangeLeave.user_click_Leave_section_and_Choose_Linda_Anderson_s_number_leave_days()"
});
formatter.result({
  "duration": 4026394075,
  "status": "passed"
});
formatter.match({
  "location": "OrangeLeave.user_verify_Linda_Anderson_s_number_leave_days_properly_calculated_by_going_to_details_of_leave_and_counting_the_day()"
});
formatter.result({
  "duration": 6320985305,
  "status": "passed"
});
formatter.after({
  "duration": 148900869,
  "status": "passed"
});
});