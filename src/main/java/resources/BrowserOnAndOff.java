package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import pages.LoginPage;
import pages.MyHomePage;
import pages.WelcomePage;

public class BrowserOnAndOff {
	public static ChromeDriver driver;
	public static String VCNsheet;
	public static String VCNCredentials;
	
	@BeforeSuite
	public void browserOn() throws IOException{
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
	/*	ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");//running the code by headless
*/		driver = new ChromeDriver();
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\PortalLinks.properties");
		prop.load(fis);
		String link = prop.getProperty("Link");
		driver.get(link);
		driver.manage().window().maximize();	
	}
	
	
	@AfterSuite
	public void browserOff() throws InterruptedException{
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		String[][] exceldata = ExcelData.readExcel(VCNsheet);
		return exceldata;
	}
	
	public void screenshot(String name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+name+".png");
		FileUtils.copyFile(src,dest);
	}

	
}
