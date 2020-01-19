package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	BrowserOnAndOff b=new BrowserOnAndOff();
	
	  public void onTestFailure(ITestResult result) {
		  try {
			  b.screenshot(result.getName().concat(" failure"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
