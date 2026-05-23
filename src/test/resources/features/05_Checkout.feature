Feature: Checkout Module

Scenario: Proceed to checkout

Given user launches automation exercise website
When user adds product to cart
And user clicks proceed to checkout
Then checkout page should display


Scenario: Enter address details

Given user launches automation exercise website
When user proceeds to checkout
And user enters address details
Then address should save successfully


Scenario: Verify order review

Given user launches automation exercise website
When user proceeds to checkout
Then order review should display


Scenario: Place order successfully

Given user launches automation exercise website
When user completes checkout process
Then order should place successfully