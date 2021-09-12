package stepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject1.LoginPage1;

public class Steps1 extends BaseClass1 {
	public WebDriver driver;
	public LoginPage1 lp;
	public Logger logger;
	public Properties prop;
	@Before
	public void setup() throws IOException {
		
		prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		
		logger = Logger.getLogger("NopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		String br = prop.getProperty("Browser");
		
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromePath"));
			driver = new ChromeDriver();}
		
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FireFoxPath"));
			driver = new FirefoxDriver();}
		
		
		logger.info("*********** Launchng browser *********");
		
	}

   @Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	   lp = new LoginPage1(driver);
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		logger.info("*********** Opening the URL *********");
		driver.get(url);
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
			logger.info("*********** Incorrect credentials entered *********");
			driver.close();
			Assert.assertTrue(false);
		}
		else
			Assert.assertEquals(title, driver.getTitle());
		logger.info("*********** Login Passed *********");
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


}

