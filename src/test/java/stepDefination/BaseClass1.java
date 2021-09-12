package stepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import pageObject1.AddCustomerPage1;
import pageObject1.LoginPage1;
import pageObject1.SearchcustomerPage1;

public class BaseClass1 {
	public WebDriver driver;
	public LoginPage1 lp;
	public AddCustomerPage1 acp;
	public SearchcustomerPage1 scp;
	public Logger logger;
	public Properties prop;
	
	public static String randomestring() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;		
	}
}
