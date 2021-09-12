package pageObject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities1.WaitHelper1;

public class SearchcustomerPage1 {

	public WebDriver ldriver;
	public WaitHelper1 waithelper;

	public SearchcustomerPage1(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);	
		waithelper = new WaitHelper1(ldriver);
	}


	@FindBy(xpath="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement setEmail;

	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement txtFirstname;

	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(id="SearchMonthOfBirth")
	@CacheLookup
	WebElement txtMonthOfBirth;

	@FindBy(id="SearchDayOfBirth")
	@CacheLookup
	WebElement txtDayOfBirth;

	@FindBy(id="SearchCompany")
	@CacheLookup
	WebElement txtCompany;

	@FindBy(id="SearchIpAddress")
	@CacheLookup
	WebElement txtIpAddress;

	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;	

	@FindBy(xpath="//span[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement listItemAdministrators;

	@FindBy(xpath="//span[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement listItemForumModerators;

	@FindBy(xpath="//span[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listItemGuests;

	@FindBy(xpath="//span[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listItemRegistered;

	@FindBy(xpath="//span[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listItemVendors;

	@FindBy(id="search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(xpath="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		//waithelper.waitForElement(setEmail,30);
		setEmail.clear();
		setEmail.sendKeys(email);		
	}

	public void setFirstname(String fname) {
		//waithelper.waitForElement(txtFirstname, 30);
		txtFirstname.clear();
		txtFirstname.sendKeys(fname);		
	}

	public void setLasttname(String lname) {
		//waithelper.waitForElement(txtLastName,30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);		
	}

	public void clickSearch() {
		btnSearch.click();
		//waithelper.waitForElement(btnSearch, 30);
	}

	public int getRowNum() {
		return (tableRows.size());
	}

	public int getColumnNum() {
		return (tableColumns.size());		
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag=false;
		for (int i = 1; i <= getRowNum(); i++) {
			String emailid = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println("Email entered for search: "+emailid);
			if (emailid.equalsIgnoreCase("admin@yourStore.com"))
				flag = true;
		}

		return flag;
	}
	
	public boolean searchCustomerByName(String Name) {
		boolean flag=false;
		for (int i = 1; i <= getRowNum(); i++) {
			String name = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println("Name entered for search: "+name);
			if (name.equalsIgnoreCase(Name))
				flag = true;
		}

		return flag;
	}

}
