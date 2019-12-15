$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AwsCalculator.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# new feature"
    },
    {
      "line": 2,
      "value": "# Tags: optional"
    }
  ],
  "line": 4,
  "name": "Testing AWS Calculator",
  "description": "",
  "id": "testing-aws-calculator",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2692255089,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Testing calculation of prices EC2 instances",
  "description": "",
  "id": "testing-aws-calculator;testing-calculation-of-prices-ec2-instances",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@TECTC-110"
    },
    {
      "line": 6,
      "name": "@ui"
    },
    {
      "line": 6,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User navigates to AWS Calculator Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User adds 2 EC2 instances",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User adds 2 EC2 Dedicated Hosts",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Total estimated cost has to match with prices on \"testData\" \"Sheet2\" excel file",
  "keyword": "Then "
});
formatter.match({
  "location": "AwsCalculatorSteps.user_navigates_to_AWS_Calculator_Homepage()"
});
formatter.result({
  "duration": 1440911180,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 10
    },
    {
      "val": "2",
      "offset": 14
    }
  ],
  "location": "AwsCalculatorSteps.user_adds_ECS_instances(int,int)"
});
formatter.result({
  "duration": 7822943115,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 10
    },
    {
      "val": "2",
      "offset": 14
    }
  ],
  "location": "AwsCalculatorSteps.user_adds_ECS_Dedicated_Hosts(int,int)"
});
formatter.result({
  "duration": 5409211980,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testData",
      "offset": 50
    },
    {
      "val": "Sheet2",
      "offset": 61
    }
  ],
  "location": "AwsCalculatorSteps.total_estimated_cost_has_to_match_with_prices_on_excel_file(String,String)"
});
formatter.result({
  "duration": 5616307584,
  "error_message": "java.lang.AssertionError: expected:\u003c9329.96\u003e but was:\u003c9378.67\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\n\tat org.junit.Assert.assertEquals(Assert.java:553)\n\tat org.junit.Assert.assertEquals(Assert.java:683)\n\tat stepDefs.AwsCalculatorSteps.total_estimated_cost_has_to_match_with_prices_on_excel_file(AwsCalculatorSteps.java:54)\n\tat ✽.Then Total estimated cost has to match with prices on \"testData\" \"Sheet2\" excel file(AwsCalculator.feature:11)\n",
  "status": "failed"
});
formatter.after({
  "duration": 767921713,
  "status": "passed"
});
});