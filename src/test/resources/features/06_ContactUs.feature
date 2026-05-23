Feature: Contact Us Module

Scenario: Submit contact form with valid data

Given user launches automation exercise website
When user clicks on Contact Us button
And user enters contact form details
Then contact form should submit successfully


Scenario: Verify success message

Given user launches automation exercise website
When user clicks on Contact Us button
And user enters contact form details
Then success message should display


Scenario: Upload file in contact form

Given user launches automation exercise website
When user clicks on Contact Us button
And user uploads file
Then file should upload successfully