package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BrowserOnAndOff;

public class WelcomePage extends BrowserOnAndOff{
	
	public MyHomePage crmsfa() {
		driver.findElementByLinkText("CRM/SFA").click();
		return new MyHomePage();
	}
	
	public LoginPage logout() {
		driver.findElementByClassName("decorativeSubmit").click();
		return new LoginPage();
	}

}
