package Testcases_Package;
import org.testng.annotations.Test;
import Pages_Package.AboutUS_Page;
import Pages_Package.BaseClass_Browser;
import Pages_Package.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


@Listeners(ListenerPackage.ListenersTestNG.class)
public class TestCase_AboutUSPage extends BaseClass_Browser
{
	WebDriver driver;
  @Test
  public void Testcase_GoToSauceSite() throws Exception
  {
	  AboutUS_Page objAbout=new AboutUS_Page(driver);
	 objAbout.Goto_AboutUs_Page();
	 Assert.assertEquals(driver.getTitle(), "Testing");
  }
  @BeforeMethod
  public void  beforeMethod(String browser) throws Exception
  {
	 // driver=super.Setup_Browser();
	  driver=super.Setup_HeadlessBrowser();
	  LoginPage objLogin=new LoginPage(driver);
	  objLogin.Login_Testcases("standard_user", "secret_sauce");
  }
  @AfterMethod
  public void afterMethod()
  {
	  System.out.print("Current Page Name is: "+driver.getTitle() +"\n" + driver.getCurrentUrl() +"\n" );
  }
}
