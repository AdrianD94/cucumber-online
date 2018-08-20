Feature: Qustodio Login Test
Scenario Outline: Login
  Given Users is on family portal
  When User insert "<email>" and "<password>"
  And Click on Login button
  Then users is redirected to the family portal dashboard
Examples:
  | email   | password |
  | adytestare+816a@gmail.com | test123456 |
