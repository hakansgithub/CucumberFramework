$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("VerifyLoginFunctionality.feature");
formatter.feature({
  "line": 2,
  "name": "Verify Login fuctionality",
  "description": "",
  "id": "verify-login-fuctionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@TEC-101"
    },
    {
      "line": 1,
      "name": "@RegressionTest"
    },
    {
      "line": 1,
      "name": "@ui"
    }
  ]
});
formatter.before({
  "duration": 3498480028,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Common first steps",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Nagivate to login page",
  "keyword": "Given "
});
formatter.match({
  "location": "VerifyLog.nagivate_to_login_page()"
});
formatter.result({
  "duration": 3063855114,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Verify with valid credentials",
  "description": "",
  "id": "verify-login-fuctionality;verify-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User logs in with valid credentials username \"Tester\" password \"test\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Verify user is in Homepage",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Tester",
      "offset": 46
    },
    {
      "val": "test",
      "offset": 64
    }
  ],
  "location": "VerifyLog.user_logs_in_with_valid_credentials_username_password(String,String)"
});
formatter.result({
  "duration": 685235511,
  "status": "passed"
});
formatter.match({
  "location": "VerifyLog.verify_user_is_in_Homepage()"
});
formatter.result({
  "duration": 17662292,
  "status": "passed"
});
formatter.after({
  "duration": 125350087,
  "status": "passed"
});
formatter.before({
  "duration": 1936568422,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Common first steps",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Nagivate to login page",
  "keyword": "Given "
});
formatter.match({
  "location": "VerifyLog.nagivate_to_login_page()"
});
formatter.result({
  "duration": 2496545529,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Verify with invalid credentials",
  "description": "",
  "id": "verify-login-fuctionality;verify-with-invalid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "User logs in with invalid credentials username \"Testers\" password \"test\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Verify user gets error message\"Invalid Login or Password.\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Testers",
      "offset": 48
    },
    {
      "val": "test",
      "offset": 67
    }
  ],
  "location": "VerifyLog.user_logs_in_with_invalid_credentials_username_password(String,String)"
});
formatter.result({
  "duration": 345192742,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Invalid Login or Password.",
      "offset": 31
    }
  ],
  "location": "VerifyLog.verify_user_gets_error_message(String)"
});
formatter.result({
  "duration": 64129334,
  "status": "passed"
});
formatter.after({
  "duration": 104238970,
  "status": "passed"
});
});