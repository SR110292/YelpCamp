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

public class LeadUploading extends BrowserOnAndOff{
	@BeforeTest
	public void login() throws IOException {
		VCNsheet = "VCN";
		String[][] credential = ExcelData.readExcel("VCN credentials");
		new LoginPage()
		.username(credential[0][0])
		.password(credential[0][1])
		.login()
		.crmsfa();
	}

	@Test
	public void leadUploading() throws InterruptedException, IOException 
	{
		String logname = "Lead Uploading";
		new MyHomePage()
		.leads()
		.uploadleads()
		.checkTitle()
		.chooseFile("C:\\pdf\\Course_227370_2019-07-04-18-25.pdf")
		.clickUpload()
		.checkUpload();
		
		screenshot(logname);

	}
	@AfterTest
	public void logoff() {
		new MyHomePage()
		.opentaps()
		.logout();
	}

}
