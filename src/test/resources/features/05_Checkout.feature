@checkout
Feature: Checkout Module

Background:

Given user launches automation exercise website
When user clicks on Signup Login button
And user enters valid login credentials


Scenario: Proceed to checkout

When user clicks on Products button
And user adds product to cart
And user clicks on Cart button
And user clicks proceed to checkout
Then checkout page should display


Scenario: Enter address details

When user clicks on Products button
And user adds product to cart
And user clicks on Cart button
And user proceeds to checkout
And user enters address details
Then address should save successfully


Scenario: Verify order review

When user clicks on Products button
And user adds product to cart
And user clicks on Cart button
And user proceeds to checkout
Then order review should display


Scenario: Place order successfully
When user clicks on Products button
And user adds product to cart
And user clicks on Cart button
And user proceeds to checkout
And user completes checkout process
And user enters payment details
And user clicks pay and confirm order
Then order should place successfully
And user clicks logout button
Then login page should display