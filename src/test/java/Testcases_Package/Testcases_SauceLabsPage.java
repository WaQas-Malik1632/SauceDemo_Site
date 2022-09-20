package Testcases_Package;
import org.testng.annotations.Test;
import Pages_Package.AboutUS_Page;
import Pages_Package.BaseClass_Browser;
import Pages_Package.LoginPage;
import Pages_Package.SauceLabs_Page;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Testcases_SauceLabsPage extends BaseClass_Browser
{
	WebDriver driver;
  @Test
  public void Testcase_verifytheSendrequestToSalesTeam()
  {
	  SauceLabs_Page labpage=new SauceLabs_Page(driver);
	  labpage.pre_requiste();
	  labpage.Contact_SalesForm("Mabrook", "Viki", "Test", "Abctest@gmail.com", "00200320303033", "Textttjkshdkjsadjsadkjasdt","TTsaTSTSJsdHKS");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException
  {
	  //driver=super.Setup_Browser();
	  driver=super.Setup_HeadlessBrowser();
	  LoginPage login1=new LoginPage(driver);
	  login1.Login_Testcases("standard_user", "secret_sauce");
	  AboutUS_Page objAbout=new AboutUS_Page(driver);
	  objAbout.Goto_AboutUs_Page();
  }
  @AfterMethod
  public void afterMethod()
  {
	  System.out.print("Current Page Name is: "+driver.getTitle() +"\n" + driver.getCurrentUrl() +"\n" );
  }

}
