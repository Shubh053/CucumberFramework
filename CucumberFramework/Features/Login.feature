Feature: Login

@sanity
Scenario: Successfull login with valid credentials
    Given launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then Page title should be "Your store. Login"
    And close browser

@regression
Scenario Outline: Login Data Driven
		Given launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "<email>" and Password as "<password>"
    And click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then Page title should be "Your store. Login"
    And close browser
    
		Examples: 
				| email | password |
				| admin@yourstore.com | admin |
				| admin123@yourstore.com | admin123 |