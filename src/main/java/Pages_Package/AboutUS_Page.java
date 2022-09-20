package Pages_Package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AboutUS_Page implements ITestListener
{
	WebDriver driver;
	By btn_hamburger_menuIcon=By.id("react-burger-menu-btn");
	By link_About=By.id("about_sidebar_link");
	By link_Logout=By.id("logout_sidebar_link");
	
	public AboutUS_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Goto_AboutUs_Page() throws IOException
	{
		WebElement I1=driver.findElement(btn_hamburger_menuIcon);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		I1.click();
		
		WebElement I2=driver.findElement(link_About);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		I2.click();	
		
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(300)).takeScreenshot(driver);
		ImageIO.write(s.getImage(),"jpg",new File("D:\\Selenium Automation\\abc.jpg"));
	}
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
	{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
