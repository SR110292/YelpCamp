package pages;

import java.beans.Visibility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import resources.BrowserOnAndOff;

public class UploadLeadsPage extends BrowserOnAndOff{

	public UploadLeadsPage checkTitle() {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Upload Leads"));
		return this;
	}

	public UploadLeadsPage chooseFile(String path) {
		driver.findElementById("uploadedFile").sendKeys(path);
		return this;
	}

	public UploadLeadsPage clickUpload() {
		driver.findElementByXPath("//input[@value='Upload and Import']").click();
		return this;
	}
	
	public UploadLeadsPage checkUpload() {
		Assert.assertTrue((driver.findElementByXPath("//div[@class='messages']").getText()).isEmpty(), "Unable to upload the document");
		return this;
	}
}
