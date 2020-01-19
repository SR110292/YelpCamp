package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BrowserOnAndOff;

public class MyHomePage extends BrowserOnAndOff{
	
	
	public SideMenuLeads leads() {
		driver.findElementByLinkText("Leads").click();
		return new SideMenuLeads();
	}
	
	public WelcomePage opentaps() {
		driver.findElementByLinkText("opentaps").click();
		return new WelcomePage();
		
	}
	
	

}
