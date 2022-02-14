//package stepDefinitions;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.cucumber.java.en.*;
//import junit.framework.Assert;
//import pageObjects.AddCustomerPage;
//import pageObjects.LoginPage;
//
//
//@SuppressWarnings("deprecation")
//public class AddNewCustomerSteps {
//	public WebDriver driver;
//	public AddCustomerPage acp;
//	
//	@Given("launch chrome browser")
//	public void launch_chrome_browser() {
//		System.setProperty("webdriver.chrome.driver", "D://eclipse-workspace//CucumberFramework//Drivers//chromedriver.exe");
//	   driver = new ChromeDriver();
//	   acp = new AddCustomerPage(driver);
//	}
//
//	@When("user opens url {string}")
//	public void user_opens_url(String url) {
//	   driver.get(url);
//	}
//
//	@When("user enters Email as {string} and Password as {string}")
//	public void user_enters_email_as_and_password_as(String email, String password) {
//		acp.setUserName(email);
//		acp.setPassword(password);
//	}
//
//	@When("click on login")
//	public void click_on_login() {
//		acp.clickLogin();
//	}
//
//	@SuppressWarnings("deprecation")
//	@Then("Page title should be {string}")
//	public void page_title_should_be(String title) {
//	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
//	    	driver.close();
//	    	Assert.assertTrue(false);
//	    } else {
//	    	Assert.assertEquals(title, driver.getTitle());
//	    }
//	}
//	
//	@When("users click Customers menu")
//	public void users_click_customers_menu() {
//	    
//	}
//
//	@When("user clicks add new customer button")
//	public void user_clicks_add_new_customer_button() {
//	    
//	}
//
//	@Then("create new cutomer page should open")
//	public void create_new_cutomer_page_should_open() {
//	    
//	}
//
//	@When("user enters customer info")
//	public void user_enters_customer_info() {
//	    
//	}
//
//	@When("click on save button")
//	public void click_on_save_button() {
//	    
//	}
//
//	@Then("confirmation message should display {string}")
//	public void confirmation_message_should_display(String string) {
//	   
//	}
//	
//	@When("user click on logout link")
//	public void user_click_on_logout_link() {
//	    acp.clickLogout();
//	}
//
//	@Then("close browser")
//	public void close_browser() {
//	    driver.close();
//	}
//}
