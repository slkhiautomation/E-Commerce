Feature: Product Detail Page

  Background:
    Given Navigate to Application

  Scenario: Validate user is able to add the searched Product in Shopping Bag
    When user search the product
    And Click on search button
    Then user able to see searched product in result
    And user select product
    Then validate the product details
    And user Add product to Cart
    Then assert product has been added