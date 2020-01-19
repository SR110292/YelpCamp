package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BrowserOnAndOff;

public class SideMenuLeads extends BrowserOnAndOff{
	
	
	public MyLeadsPage myleads() {
		driver.findElementByLinkText("My Leads").click();
		return new MyLeadsPage();
	}
	
	public CreateLeadPage createlead() {
		driver.findElementByLinkText("Create Lead").click();
		return new CreateLeadPage();
	}
	
	public FindLeadsPage findleads() {
		driver.findElementByLinkText("Find Leads").click();
		return new FindLeadsPage();
	}
	
	public MergeLeadsPage mergeleads() {
		driver.findElementByLinkText("Merge Leads").click();
		return new MergeLeadsPage();
	}
	
	public UploadLeadsPage uploadleads() {
		driver.findElementByLinkText("Upload Leads").click();
		return new UploadLeadsPage();
	}
	
	public RequestCatalog requestcatalog() {
		driver.findElementByLinkText("Request Catalog").click();
		return new RequestCatalog();
	}
	
}
