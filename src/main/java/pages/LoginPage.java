package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BrowserOnAndOff;

public class LoginPage extends BrowserOnAndOff{
		
	public LoginPage username(String name) {
		driver.findElement(By.id("username")).sendKeys(name);
		return this;
	}
	
	public LoginPage password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public WelcomePage login() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();
	}
	
	
}
