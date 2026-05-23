Feature: Signup Module

Scenario: Register user with valid details

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters signup details
Then user should register successfully


Scenario: Register user with existing email

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters already registered email
Then proper signup error should display


Scenario: Verify validation messages

Given user launches automation exercise website
When user clicks on Signup Login button
And user clicks signup button without data
Then validation message should display


Scenario: Verify successful account creation

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters signup details
Then account should create successfully