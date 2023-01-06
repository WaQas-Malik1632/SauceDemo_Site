package Testcases_Package;
import org.testng.annotations.Test;
import Pages_Package.BaseClass_Browser;
import Pages_Package.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class ValidateLoginPage extends BaseClass_Browser
{ 
	WebDriver driver;	
  //Enter  correct username and correct Password
	@Test(invocationCount = 4,priority=1, description="Login Test#1", groups = {"sanity_Suite", "regression_Suite"})
	@Description("Verify test using these credentials: username:standard_user  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.BLOCKER)
  public void TestcasetoVerifyLoginwithbothcorrectUsernameandPassword() throws IOException
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login_Testcases("standard_user", "secret_sauce");
	  Assert.assertTrue(true, "Passed");
	 
	 // Assert.assertTrue(facebook_Title.contains("Facebook"));
	  //System.out.println("Page title matched");
	  //System.out.println(facebook_Title);
  }
  //Enter wrong  username and wrong Password
	@Test(priority=1, description="Login Test#2", groups = {"sanity_Suite", "regression_Suite"} ,enabled = true )
	@Description("Verify test using these credentials: username:standard_user  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
  public void TestcasetoVerifyLoginwith_bothWrongUsernameandPassword()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login_Testcases("WAQAS00999","Test@____/%!123");
	 // throw new SkipException("Skipping the test");
	  Assert.assertTrue(true, "Passed");
	  //Assert.fail("Failed test");
  }
  //Enter wrong username and Password correct
	@Test(priority=1, description="Login Test#3", groups = {"sanity_Suite", "regression_Suite"} ,enabled = true )
	@Description("Verify test using these credentials: username:standard_user  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.TRIVIAL)
  public void TestcasetoVerifyLoginwith_WrongUsernameandCorrectPassword()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login_Testcases("Standard","secret_sauce");
	  Assert.assertTrue(false, "Failed");
  }
  //Enter Correct username and wrong Password
	@Test(priority=1, description="Login Test#4", groups = {"regression_Suite"} ,enabled = true )
	@Description("Verify test using these credentials: username:standard_user  password: @1_)()**^%$#@$msd_MALIK_Waqas")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.MINOR)
  public void TestcasetoVerifyLoginwith_CorrectUsernameandWrongPassword()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login_Testcases("standard_user","@1_)()**^%$#@$msd_MALIK_Waqas");
	  Assert.assertTrue(true, "Passed");
  }
	 public void Negative_Scenario_toVerifyLoginwith_CorrectPasswordOnly()
	  {
		  LoginPage login=new LoginPage(driver);
		  //
		  login.Login_Testcases_Negative("standard_user", "");
		 // Assert.fail("Failed");
		  Assert.assertTrue(false, "Failed");
	  }
  @BeforeMethod
  public void beforeMethod()
  {
	driver=super.Setup_Browser();
	//driver=super.Setup_HeadlessBrowser();
  }
  @AfterMethod
  public void afterMethod()
  {  
	  System.out.print("Current Page Name is: "+driver.getTitle() +"\n" + driver.getCurrentUrl() +"\n");
  }
}
