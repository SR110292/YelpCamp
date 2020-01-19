package pages;

import org.testng.Assert;

import resources.BrowserOnAndOff;

public class ViewLeadPage extends BrowserOnAndOff{
	
	public ViewLeadPage checkTitle() throws InterruptedException {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("View Lead"));
		return this;
	}

}
