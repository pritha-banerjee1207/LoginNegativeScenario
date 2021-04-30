Feature: Validate login negative functionality

  Scenario: Validate that the user is not allowed to login when Phone number and Password fields are blank
     Given App is open 
     
     Then User clicks on Login button


  Scenario: Validate that the user should get a validation message on entering invalid credentials in the Login Page
    When user enter invalid phone no and password
    Then validation messages should be displayed

  Scenario: Validate that user is not allowed to enter more than 10 digits in the Phone number field
    When User enters phone number with more than ten digits
    Then validation messages should be displayed

  Scenario: Validate that the user is not allowed to login with invalid Phone number and valid Password
    When user enters invalid Phone number and valid Password
    Then validation messages should be displayed

  Scenario: Validate that the user is not allowed to login with invalid Password and valid phone number
    When user enters invalid Password and valid phone number
    Then validation messages should be displayed

  Scenario: Validate that user is not able to login on leaving Phone number field blank and only giving valid Password
    When user leavs Phone number field blank
    Then validation messages should be displayed

  Scenario: Validate that user is not able to login on leaving Password field blank and only giving valid Phone number
    When user leavs Password field blank
    Then validation messages should be displayed
