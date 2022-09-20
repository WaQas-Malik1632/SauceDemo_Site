package ListenerPackage;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pages_Package.BaseClass_Browser;

public class ListenersTestNG implements ITestListener
{	
	public WebDriver webdriver=null;
	int i=1;

		public void onTestSuccess(ITestResult result) {
			System.out.println("$$$$ onTestSuccess Method: " +result.getName()+" $$$$");
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("----onTestFailure Method: " +result.getName()+" ----");
			
			BaseClass_Browser takeSS=new BaseClass_Browser();
			webdriver=takeSS.Setup_Browser();
			try {
				takeSS.TakeScreenshot(webdriver,"_(FailedTestCaseSS)"+result.getName());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		public void onTestSkipped(ITestResult result) {
			System.out.println("!!!! onTestSkipped Method: " +result.getName()+" !!!!");
		}
}