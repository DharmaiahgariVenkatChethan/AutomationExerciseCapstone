@product
Feature: Products Module

Scenario: Search products using keyword

Given user launches automation exercise website
When user clicks on Products button
And user searches product
Then product should display successfully


Scenario: Verify product details

Given user launches automation exercise website
When user clicks on Products button
Then product details should display


Scenario: Add product to cart

Given user launches automation exercise website
When user clicks on Products button
And user adds product to cart
Then product should add successfully


Scenario: Verify product category filtering

Given user launches automation exercise website
When user clicks on Products button
And user selects category
Then filtered products should display