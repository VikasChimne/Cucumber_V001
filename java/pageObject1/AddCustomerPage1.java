package pageObject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage1 {
WebDriver ldriver;
	
	public AddCustomerPage1(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);		
	}
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//span[text()='Customers']");
	By lnkCutomers_menuitem = By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	
	By addNewButton = By.xpath("//a[@class='btn bg-blue']");
	
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	
	By txtFirstName = By.id("FirstName");
	By tstLastName = By.id("LastName");
	
	By rdGenderMale = By.xpath("//input[@id='Gender_Male']");
	By rdGenderFemale = By.xpath("'//input[@id='Gender_Female']");

	By txtDob = By.id("DateOfBirth");
	
	By txtCompany = By.id("Company");
	
}
