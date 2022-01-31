Feature: Customer

  Scenario: Add new Customer
    Given user Launch Chrome Browser
    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And user enter Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then user can view Dashboard
    When user click on customers Menu
    And click on customers Menu item
    And click on Add new button
    Then user can view Add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "The new customer hass been added successfully."
    And close browser