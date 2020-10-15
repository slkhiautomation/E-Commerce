Feature: Search Page

  Background:
    Given Navigate to Application

  Scenario: Validate user is able to search the Product
    When user search the product
    And Click on search button
    Then user able to see searched product in result