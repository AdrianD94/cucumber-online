
Feature: Online.io login test with valid credentials
Scenario Outline: Login test with valid credentials and confirmed email
  Given user is on login page
  When user inserts confirmed email "<email>" and valid  password "<password>"
  Then user is redirected to the dashboard


Examples:
  | email   | password |
  | adytestare+627c@gmail.com | Test!23456 |
