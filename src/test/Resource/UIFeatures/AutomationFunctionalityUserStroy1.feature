@TEC-103
Feature:Authentication functionality
@Test1
  Scenario: Verify Create an account
    Given Nagivate to home page
    Then User click signing button
    Then  User create by signing  with valid credentials E mail "Nancykup@gmail.com"
    And  User click Create an accaount

    Then Fill up the new account form with the following data
      | First Name | Last Name | E Mail              | Password   | Adress    | City    | State | Zip   | Country | Phone No  | Assign an address |
      | Test FN    | Test LN   | Nancykup@gmail.com | 0123123123 | 123 N tec | Chicago | IL    | 60015 | USA     | 224356789 | 123 N tec         |
    Then User clicks on Register
    @Test2
    Scenario: Verify with valid credentials
      Given Nagivate to sign in  page
      And User click sign
      Then  User  in with valid credentials E mail"Nancykup@gmail.com" password "0123123123"
      And   User click sign in
      And Verify Home page "My account - My Store"
      @Test3
      Scenario: Sign in with invalid credentials
        Given  Nagivate to sign in  page
         Then User click sign
        Then  User log in with invalids credentials E mail"Nancy" password "0123123123"
       Then Verify gets error alert message "Invalid email address."


