package stepDefination;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject1.SearchcustomerPage1;
import pageObject1.AddCustomerPage1;
import pageObject1.LoginPage1;

public class Steps1 extends BaseClass1 {
	@Before
	public void setup() throws IOException {
		
	//Reading properties
		prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		
		logger = Logger.getLogger("NopCommerce");//Added logger
		PropertyConfigurator.configure("log4j.properties");//Added logger
		
		String br = prop.getProperty("Browser");
		
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromePath"));
			driver = new ChromeDriver();}
		
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FireFoxPath"));
			driver = new FirefoxDriver();}
	}
	//Adding new Customer
   @Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\Cucumber_V001\\Drivers\\chromedriver.exe");
	   lp = new LoginPage1(driver);
	 //logger.info("*********** Launchng browser *********");
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		logger.info("*********** Opening the URL *********");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String userName, String passWord) {
		logger.info("*********** Providing login details *********");
		lp.enterUsername(userName);
		lp.enterPassword(passWord);	
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		logger.info("*********** Started Login *********");
		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("*********** Incorrect credentials entered *********");
			Assert.assertTrue(false);
		}
		else
			logger.info("*********** Login Passed *********");
		    Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(3000);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("*********** Clicking on Logout *********");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("*********** Completed the test, closing the browser *********");
		driver.quit();
	}
     
	
	//Customers feature step Definitions:
	
	@Then("User can view Dashboard")//Validation part
	public void user_can_view_dashboard() {
		acp = new AddCustomerPage1(driver);
		logger.info("*********** User can view the Dashboard *********");
		Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
	}
	@When("User click on customers Menu Item")
	public void user_click_on_customers_menu_item() throws InterruptedException {
		logger.info("*********** Opening the Customer Link *********");
		acp.clickOnCustomersMenu();//Calling the method which are already defined in pageObjectclass1
		Thread.sleep(2000);
		acp.clickOnCustomersMenuItem();	
	}
	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		logger.info("*********** Clicked on the Add New Customer *********");
		acp.clickOnAddnew();
		Thread.sleep(2000);
	}
	@Then("User can view Add new Customer page") //validation part
	public void user_can_view_add_new_customer_page() {
		logger.info("*********** Verifying thr Customer page Title *********");
	
	Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
	}
	@When("User enter Customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		logger.info("*********** Adding New Customer *********");
		logger.info("***********Providing Customer Details********");
		String email = randomestring()+"@gmail.com";//without creating any object we calling this static randomString method BaseClass1
		acp.setEmail(email);
		acp.setPassword("test123");
		acp.setFirstname("Vikas");
		acp.setLastname("Patil");
		acp.setGender("Male");
		acp.setDOB("7/05/1985");
		acp.setCompanyname("Vision IT");
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add customer to 'Guests' or Registered' customer role
		//acp.setCustomerRoles("Guests");
		acp.setManagerOfVendor("Vendor 1");
		acp.setAdminComment("This is for testing........");
	}
	@When("Click on Save Button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("*********** Clicked on the Save Button *********");
		acp.clickOnSave();
		Thread.sleep(2000);
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String conMessage) throws Throwable {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
		//String expectedmessage=driver.findElement(By.tagName("body")).getText();
		
		System.out.printf("The new customer has been added successfully");
		
	}
	
//	Steps for Searching a Customer using Email Id
	
	@When("Enter Customer Email")
	public void enter_Customer_Email() throws Throwable {
		logger.info("*********** Searching customer by Email *********");
		scp = new SearchcustomerPage1(driver);
		Thread.sleep(3000);
		scp.setEmail("admin@yourStore.com");
    }
    @Then("Click on search button")
	public void click_on_search_button() throws Throwable {
		logger.info("*********** Clicked on the search Button *********");
		scp.clickSearch();
		Thread.sleep(3000);
	}
    @Then("User should find the customer email in the search tble")
	public void user_should_find_the_customer_email_in_the_search_tble() throws Throwable {
		System.out.println("Number of rows in the table is: "+scp.getRowNum());
		boolean status = scp.searchCustomerByEmail("admin@yourStore.com");
		Assert.assertEquals(true, status);
	}
	
//	Steps for Searching a Customer using First Name and Last Name
    
	@When("Enter Customer Firstname")
	public void enter_Customer_Firstname() throws Throwable {
		
		logger.info("*********** Searching customer by Name *********");
		scp = new SearchcustomerPage1(driver);
		scp.setFirstname("John");	    
	}

	@When("Enter Customer Lastname")
	public void enter_Customer_Lastname() throws Throwable {
		scp = new SearchcustomerPage1(driver);
		scp.setLasttname("Smith");	    
	}

	@Then("User should find the Name in the search table")
	public void user_should_find_the_Name_in_the_search_table() throws Throwable {
		logger.info("*********** Searching customer by Name *********");
	    boolean status = scp.searchCustomerByName("John Smith");
	    Assert.assertEquals(true, status);
	}


}

