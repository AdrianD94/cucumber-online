
Feature: Online.io login test with invalid credentials
  Scenario Outline: Login test with invalid Credentials
    Given user is on online login page
    When user inserts invalid "<email>" or  invalid  password "<password>"
    Then Error Message is displayed


    Examples:
      | email   | password |
      | adytestare+627c@gmail.comm | dsaTest!23456 |
