
Feature: Online.io register test
Scenario Outline: Register test with valid credentials
  Given user is on register page
  When user inserts  email "<email>" and  password "<password>"
  Then user is redirected to the verify email page


Examples:
  | email   | password |
  | adytestare+910d@gmail.com | Test!23456 |
