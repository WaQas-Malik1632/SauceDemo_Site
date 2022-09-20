package Testcases_Package;

import org.testng.annotations.Test;
import Pages_Package.BaseClass_Browser;
import Pages_Package.Inventory_Page;
import Pages_Package.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestCase_InventoryPage extends BaseClass_Browser
{
	WebDriver driver;
  @Test
  public void Testcasetocheck_IteminCart() throws InterruptedException
  {
	  Inventory_Page mainpage=new Inventory_Page(driver);
	//  mainpage.Dropdown();
	  mainpage.ClickonItem();
	  mainpage.CheckCart();
	  mainpage.CheckoutInformation("Malik", "Waqas", "3220456");
	 // Assert.assertEquals(true, driver.getTitle(), "Inventory Page");
  }

  @BeforeMethod
  public void beforeMethod() throws Exception 
  {
	//driver=super.Setup_Browser();
	 driver=super.Setup_HeadlessBrowser();
	 LoginPage login1=new LoginPage(driver);
	 login1.Login_Testcases("standard_user", "secret_sauce");	
  }
  @AfterMethod
  public void afterMethod()
  {
	  System.out.print("Current Page Name is: "+driver.getTitle() +"\n" + driver.getCurrentUrl() +"\n" );
  }
}

