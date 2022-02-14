Feature: Customers

	Background: Below are common steps for every sceanrio
		 Given launch chrome browser
	   When user opens url "https://admin-demo.nopcommerce.com/login"
	   And user enters Email as "admin@yourstore.com" and Password as "admin"
	   And click on login
     Then Page title should be "Dashboard / nopCommerce administration"

@sanity     
  Scenario: Add New Customer
    When users click Customers menu
    And user clicks add new customer button
    When user enters customer info and click save button
    Then confirmation message should display "The new customer has been added successfully."
    When user click on logout link
    Then Page title should be "Your store. Login"
    And close browser
    
#@regression    
   #Scenario: Search customer by using Email Id
   #		When user click on customer menu
   #		And enter customer Email
   #		When click on search button
   #		Then user should found Email in the search table
   #		When user click on logout link
#	    Then Page title should be "Your store. Login"
#	    And close browser
