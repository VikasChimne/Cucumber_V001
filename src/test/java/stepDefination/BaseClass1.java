package stepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import pageObject1.AddCustomerPage1;
import pageObject1.LoginPage1;
import pageObject1.SearchcustomerPage1;

public class BaseClass1 {//Here we put only Common things
	public WebDriver driver;
	public LoginPage1 lp;
	public AddCustomerPage1 acp;
	public SearchcustomerPage1 scp;
	public Logger logger;
	public Properties prop;
	
	//Created for generating random string for Unique email id
	public static String randomestring() {//java method,predefined class
		String generatedString = RandomStringUtils.randomAlphabetic(5);//5 charector
		return generatedString;		
	}
}
