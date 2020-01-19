package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FindLeadsPage extends CreateLeadPage {

	public FindLeadsPage clicknameandid() {
		driver.findElementByXPath("//span[text() ='Name and ID']").click();
		return this;
		
	}
	
	public FindLeadsPage enterfirstname(String firstname) {
		driver.findElement(By.xpath("(//input[@name ='firstName'])[3]")).sendKeys(firstname);
		return this;
	}
	
	public FindLeadsPage enterlastname(String lastname) {
		driver.findElementByXPath("(//input[@name ='lastName'])[3]").sendKeys(lastname);
		return this;
	}
	
	public FindLeadsPage entercompanyname(String companyname) {
		driver.findElementByXPath("(//input[@name ='companyName'])[2]").sendKeys(companyname);
		return this;
	}
	
	public FindLeadsPage clickfindleads() throws InterruptedException {
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		return this;
	}
	
	public FindLeadsPage verifyfirstname(String firstname) {
		String text = driver.findElementByXPath("(//table[@class='x-grid3-row-table']/tbody/tr/td[3])[1]").getText();
		Assert.assertEquals(text, firstname, "actual text in the webportal and first name in the excel sheet are not matching. Hence failed");
		return this;
	}
	
	public FindLeadsPage verifylastname(String lastname) {
		String text = driver.findElementByXPath("(//table[@class='x-grid3-row-table']/tbody/tr/td[4])[1]").getText();
		Assert.assertEquals(text, lastname, "actual text in the webportal and last name in the excel sheet are not matching. Hence failed");
		return this;
	}
}
