package pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.collections.Lists;

import resources.BrowserOnAndOff;

public class CreateLeadPage extends BrowserOnAndOff{


	public CreateLeadPage companyname(String name) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(name);
		return this;	//control goes to the same page
	}

	public CreateLeadPage forename(String name) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(name);
		return this;	
	}

	public CreateLeadPage surname(String name) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(name);
		return this;	
	}

	public CreateLeadPage source(String value) {
		Select dd = new Select(driver.findElement(By.id("createLeadForm_dataSourceId")));
		dd.selectByVisibleText(value);
		return this;	
	}

	public CreateLeadPage parentaccounticon() {
		driver.findElementByXPath("//input[@id='createLeadForm_parentPartyId']/following-sibling::a").click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> window  = new ArrayList<String>(windowHandles);
//		driver.switchTo().window(window.get(1));
//		driver.close();
		driver.switchTo().window(window.get(0));
		return this;
	}

	public CreateLeadPage marketingcampaign(String value) {
		Select dd = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		dd.selectByVisibleText(value);
		return this;		
	}

	public CreateLeadPage dateofbirth(String value) {
		driver.findElementByXPath("//input[@id='createLeadForm_birthDate']/following-sibling::a").click();
		String text = driver.findElementByXPath("//thead/tr/td[2]").getText();
		String[] DOB = value.split("/");
		String date = DOB[0].trim();
		String month = DOB[1].trim();
		String year = DOB[2].trim();
		
		while(!text.contains(year)) {
			driver.findElementByXPath("//tr[@class = 'headrow']/td[1]").click();
			text = driver.findElementByXPath("//thead/tr/td[2]").getText();
		}
		while(!text.contains(month)) {
			driver.findElementByXPath("//tr[@class = 'headrow']/td[2]").click();
			text = driver.findElementByXPath("//thead/tr/td[2]").getText();
		}
		List<WebElement> weekdays = driver.findElementsByXPath("//td[@class='day']");
		List<WebElement> weekends = driver.findElementsByCssSelector("td.day.weekend");
		for(WebElement x:weekdays) {
			if(x.getText().equals(date)) {
				x.click();
				break;
			}

		}
		for(WebElement x:weekends) {
			if(x.getText().equals(date)) {
				x.click();
				break;
			}

		}
		return this;		
	}

	public CreateLeadPage preferredcurrency(String value) {
		Select dd = new Select(driver.findElement(By.id("createLeadForm_currencyUomId")));
		dd.selectByVisibleText(value);
		return this;	
	}

	public ViewLeadPage createlead() throws InterruptedException {
		driver.findElementByClassName("smallSubmit").click();
		Thread.sleep(1000);
		return new  ViewLeadPage();
	}
}
