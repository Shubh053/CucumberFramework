package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utilities.WaitHelper;

public class AddCustomerPage {
	public WebDriver driver;
	WaitHelper waitHelper;
	
	// constructor to initilise element at the time of object creation
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	// locators
		@FindBy(id="Email")
		WebElement txtEmail;
		
		@FindBy(id="Password")
		WebElement txtPassword;
		
		@FindBy(xpath="//button[text()='Log in']")
		WebElement btnLogin;
		
		@FindBy(xpath="//ul[@role='menu' and @data-widget='treeview']//i[@class='nav-icon far fa-user']/following-sibling::p[contains(.,'Customers')]")
		WebElement customerSideMenu;
		
		@FindBy(xpath="//a[@href='/Admin/Customer/List']/p[text()=' Customers']")
		WebElement customerMenu;
		
		@FindBy(xpath="//h1[contains(.,'Customers')]")
		WebElement customerListPageHeading;
		
		@FindBy(xpath="//a[contains(.,'Add new')]")
		WebElement addNewCustomerBtn;
		
		@FindBy(xpath="//h1[contains(.,'Add a new')]")
		WebElement customerCreationPageHeading;
		
		@FindBy(id="Email")
		WebElement inputEmail;
		
		@FindBy(xpath="//button[@name='save']")
		WebElement saveBtn;
		
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
		WebElement confirmMsg;
		
		@FindBy(linkText="Logout")
		WebElement lnkLogout;
	
		// Business Logic
		public void setUserName(String uname) {
			txtEmail.clear();
			txtEmail.sendKeys(uname);
		}
		
		public void setPassword(String pwd) {
			txtPassword.clear();
			txtPassword.sendKeys(pwd);
		}
		
		public void clickLogin() {
			btnLogin.click();
		}
		
		public void clickCustomer() throws InterruptedException {
			customerSideMenu.click();
			Thread.sleep(3000);
			customerMenu.click();
		}
		
		public void clickAddCustomer() {
			waitHelper.waitForElement(customerListPageHeading, 20);
			addNewCustomerBtn.click();
		}
		
		public void createNewCustomer(String email) {
			waitHelper.waitForElement(customerCreationPageHeading, 20);
			inputEmail.sendKeys(email);
			saveBtn.click();
		}
		
		@SuppressWarnings("deprecation")
		public void verifyConfirmationMessage(String expectedMsg) {
			String msg = confirmMsg.getText().trim();
			Assert.assertEquals(expectedMsg, msg);
		}
		
		public void clickLogout() {
			lnkLogout.click();
		}
}
