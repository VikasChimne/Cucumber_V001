package stepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.AddCustomerPage;
import pageObject.LoginPage1;
import pageObject.SearchCustomerPage;

public class BaseClass1 {
	public WebDriver driver;
	public LoginPage1 lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	public Logger logger;
	public Properties prop;
	
	public static String randomestring() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;		
	}
}
