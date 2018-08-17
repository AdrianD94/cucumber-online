Feature: Qustodio Login Test
Scenario: Login
  Given Users is on family portal
  When User insert valid "credentials"
  And Click on Login button
  Then users is redirected to the family portal dashboard

