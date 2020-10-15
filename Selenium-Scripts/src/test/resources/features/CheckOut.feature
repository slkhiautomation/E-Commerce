Feature: Checkout

  Background:
    Given Navigate to Application

  Scenario: Validate user is able to proceed guest checkout on searched product
    When user search the product
    And Click on search button
    Then user able to see searched product in result
    And user select product
    Then validate the product details
    And user Add product to Cart
    Then assert product has been added
    And proceed to checkout
    Then assert that Guest CheckOut available
    And enter zipCode
    And proceed to Guest Checkout
    And click on CheckOut
    Then assert navigated to Guest Checkout page
    And user enter shipping information