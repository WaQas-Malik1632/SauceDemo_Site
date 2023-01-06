package ListenerPackage;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Pages_Package.BaseClass_Browser;
import io.qameta.allure.Allure;

public class ListenersTestNG implements ITestListener
{	
	public WebDriver webdriver=null;

		public void onTestSuccess(ITestResult result)
		{
			System.out.println("$$$$ onTestSuccess Method: " +result.getName()+" $$$$");
		}
		public void onTestFailure(ITestResult result)
		{
			System.out.println("----onTestFailure Method: " +result.getName()+" ----");
			//Use this for take screenshot in the local folder
			 BaseClass_Browser takeSS=new BaseClass_Browser();
			 webdriver=takeSS.Setup_Browser();
			Allure.addAttachment("FailedTestCase_screenshot", new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES)));
			
			//Use this for take screenshot in the local folder
			/*	
			try 
			{
				takeSS.TakeScreenshot(webdriver,"_(FailedTestCaseSS)"+result.getName());
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
			}
		public void onTestSkipped(ITestResult result)
		{
			System.out.println("!!!! onTestSkipped Method: " +result.getName()+" !!!!");
		}
}