@login
Feature: Login Module

Scenario: Login with valid credentials

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters valid login credentials
Then user should login successfully


Scenario: Login with invalid credentials

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters invalid login credentials
Then login error message should display


Scenario: Verify logout functionality

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters valid login credentials
And user clicks logout button
Then login page should display


Scenario: Verify login error messages

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters invalid login credentials
Then proper login validation message should display