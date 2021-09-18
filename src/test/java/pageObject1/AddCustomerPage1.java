package pageObject1;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage1 {
WebDriver ldriver;
	
	public AddCustomerPage1(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);		
	}
	
	By lnkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCutomers_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By addNewButton = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	
	By txtFirstName = By.id("FirstName");
	By tstLastName = By.id("LastName");
	
	By rdGenderMale = By.xpath("//input[@id='Gender_Male']");
	By rdGenderFemale = By.xpath("'//input[@id='Gender_Female']");

	By txtDob = By.id("DateOfBirth");
	
	By txtCompany = By.id("Company");
	
By txtAdminComment = By.id("AdminComment");
	
	By txtCustomerRoles = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	By listitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By listitemForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	//By listitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By listitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By listitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By dropVendor = By.id("VendorId");
		
	By btnSave = By.xpath("//button[@name='save']");
	
	//Actions Methods
	
	public String getPageTitle() 
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {    //Created all methods
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCutomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		ldriver.findElement(addNewButton).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setFirstname(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		ldriver.findElement(tstLastName).sendKeys(lname);
	}
	
	public void setGender(String gender) {
		
		if (gender.equalsIgnoreCase("Male"))
			ldriver.findElement(rdGenderMale).click();
		else if (gender.equalsIgnoreCase("Female"))
			ldriver.findElement(rdGenderFemale).click();
	}
	
	public void setDOB(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyname(String cname) {
		ldriver.findElement(txtDob).sendKeys(cname);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		
		if(!role.equalsIgnoreCase("registered")) {
			ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")).click();
			}
		
		ldriver.findElement(txtCustomerRoles).click();
		
		WebElement listitem;
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
			listitem = ldriver.findElement(listitemAdministrators);
		else if(role.equals("Forum Moderators"))
			listitem = ldriver.findElement(listitemForumModerators);
		//else if(role.equals("Guests"))
			//listitem = ldriver.findElement(listitemGuests);
		else if(role.equals("Registered"))
			listitem = ldriver.findElement(listitemRegistered);
		else 
			listitem = ldriver.findElement(listitemVendors);
		
		listitem.click();
		//Thread.sleep(3000);
		//JavascriptExecutor js = (JavascriptExecutor)ldriver;
		//js.executeScript("arguments[0].click();", listitem);
	}
	
	public void setManagerOfVendor(String value) {		
		Select drp = new Select(ldriver.findElement(dropVendor));
		drp.selectByVisibleText(value);		
	}
	
	public void setAdminComment(String comment) {
		ldriver.findElement(txtAdminComment).sendKeys(comment);
	}
	
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
	
}
