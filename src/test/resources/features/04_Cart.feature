Feature: Cart Module

Scenario: Verify cart page access

Given user launches automation exercise website
When user clicks on Cart button
Then cart page should open successfully


Scenario: Update product quantity

Given user launches automation exercise website
When user adds product to cart
And user updates quantity
Then quantity should update successfully


Scenario: Remove product from cart

Given user launches automation exercise website
When user adds product to cart
And user removes product
Then cart should become empty


Scenario: Verify total amount

Given user launches automation exercise website
When user adds product to cart
Then total amount should display