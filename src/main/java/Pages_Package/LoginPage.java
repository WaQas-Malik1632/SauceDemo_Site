package Pages_Package;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage
{
	WebDriver driver;
	
	By txt_username=By.id("user-name");
	By txt_password=By.id("password");
	By btn_login=By.id("login-button");
	By drop_down=By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select");

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean Login_Testcases(String Uname, String Pass)
	{
		WebElement u1=driver.findElement(txt_username);
		u1.sendKeys(Uname);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement p1=driver.findElement(txt_password);
		p1.sendKeys(Pass);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //page load
		
		WebElement b1=driver.findElement(btn_login);
		b1.click();
		
		String actualUrl=driver.getCurrentUrl();
		String expectrdUrl="https://www.saucedemo.com/inventory.html";
		
		boolean cond=false;
		if(actualUrl.equalsIgnoreCase(expectrdUrl))
		{
			cond=true;
		}
		
		else 
			cond=false;
		
		return cond;
	}
	public void TakeScreenshot(WebDriver webdriver, String DestFile) throws IOException
	{
		TakesScreenshot src=((TakesScreenshot)webdriver);
		File srcfile =src.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcfile, new File(".//screenshot//djkjfs.png"));
		FileUtils.copyFile(srcfile,new File(DestFile));
	}
}
