package pageObject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

public WebDriver ldriver;
	
	public LoginPage1(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void enterUsername(String userName) {
		txtEmail.clear();
		txtEmail.sendKeys(userName);
	}
	
	public void enterPassword(String passWord) {
		txtPassword.clear();
		txtPassword.sendKeys(passWord);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout(){
		lnkLogout .click();
	}
	
}
