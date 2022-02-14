package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.AddCustomerPage;

public class LoginSteps extends BaseClass{
	
	@Before
	public void setup() throws IOException  {
		// Reading Properties file
		configProp = new Properties();	
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		// Added logger
		logger = Logger.getLogger("Cucumber");	
		PropertyConfigurator.configure("Log4j.properties");
		
		// Select browser
		String browser = configProp.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
	   logger.info("**** launching browser ****");
	}
	
	@Given("launch chrome browser")
	public void launch_chrome_browser() {
	   lp = new LoginPage(driver);
	   acp = new AddCustomerPage(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
		logger.info("**** opening URL ****");
	   driver.get(url);
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("**** providing login credentials ****");
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("click on login")
	public void click_on_login() {
		logger.info("**** login begin ****");
	    lp.clickLogin();
	}

	@SuppressWarnings("deprecation")
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    } else {
	    	logger.info("**** logging successful ****");
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}
	
	@When("users click Customers menu")
	public void users_click_customers_menu() throws InterruptedException {
		logger.info("**** customer menu opening ****");
	    acp.clickCustomer();
	}

	@When("user clicks add new customer button")
	public void user_clicks_add_new_customer_button() {
		logger.info("**** adding new customer ****");
	    acp.clickAddCustomer();
	}

	@When("user enters customer info and click save button")
	public void user_enters_customer_info() {
		logger.info("**** providing customer details ****");
		acp.createNewCustomer(randomString() + "@gmail.com");
	}

	@Then("confirmation message should display {string}")
	public void confirmation_message_should_display(String string) {
		logger.info("**** verifying newly created customer ****");
	   acp.verifyConfirmationMessage("The new customer has been added successfully.");
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() {
		logger.info("**** logout begin ****");
	    lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("**** closing browser ****");
	    driver.close();
	}
}
