package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.LoginPage;
import pages.MyHomePage;
import pages.SideMenuLeads;
import pages.WelcomePage;
import resources.BrowserOnAndOff;
import resources.ExcelData;

public class LeadFinding extends BrowserOnAndOff{
	@BeforeTest()
	public void login() throws IOException {
		VCNsheet = "VCN";
		String[][] credential = ExcelData.readExcel("VCN credentials");
		new LoginPage()
		.username(credential[1][0])
		.password(credential[1][1])
		.login()
		.crmsfa();
	}

	@Test (dataProvider = "getData")
	public void leadFinding(String companyname, String forename, String surname, String source,
			String marketingcampaign, String DOB, String preferredcurrency) throws InterruptedException, IOException 
	{
		String logname = "Lead Finding ".concat(forename);
		new MyHomePage()
		.leads()
		.findleads()
		.clicknameandid()
		.entercompanyname(companyname)
		.enterfirstname(forename)
		.enterlastname(surname)
		.clickfindleads()
		.verifyfirstname(forename)
		.verifylastname(surname)
		;
		screenshot(logname);

	}
	@AfterTest
	public void logoff() {
		new MyHomePage()
		.opentaps()
		.logout();
	}

}
