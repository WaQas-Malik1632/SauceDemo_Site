package Pages_Package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Inventory_Page
{
	WebDriver driver;
	By Dropdownlist=By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select");
	By Itemclick1=By.id("add-to-cart-sauce-labs-backpack");
	By Itemclick2=By.id("add-to-cart-sauce-labs-bike-light");
	By Itemclick3=By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By Cartclick=By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
	By checkoutClick=By.id("checkout");
	By txt_firstname=By.id("first-name");
	By txt_lastname=By.id("last-name");
	By int_zipcode=By.id("postal-code");
	By btn_continue=By.id("continue");
	By btn_finish=By.id("finish");
	
	public Inventory_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickonItem()
	{
		WebElement I1=driver.findElement(Itemclick1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		I1.click();
		
		WebElement I2=driver.findElement(Itemclick2);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		I2.click();
		
		WebElement I3=driver.findElement(Itemclick3);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		I3.click();
		
		WebElement e1=driver.findElement(Cartclick);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		e1.click();
		
	}
	public void CheckCart()
	{
		WebElement Checkoutbtn=driver.findElement(checkoutClick);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Checkoutbtn.click();
	}
	public void CheckoutInformation(String Fname, String Lname, String Zip)
	{
		WebElement F1=driver.findElement(txt_firstname);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		F1.sendKeys(Fname);
		
		WebElement L1=driver.findElement(txt_lastname);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		L1.sendKeys(Lname);
		
		WebElement Z1=driver.findElement(int_zipcode);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Z1.sendKeys(Zip);
		
		WebElement B1=driver.findElement(btn_continue);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		B1.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window", 0,1000);
		
		WebElement finishbtn=driver.findElement(btn_finish);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		finishbtn.click();
		
	}
	
	public void takeSnapshot(WebDriver driver,String DestFile) throws IOException
	{
		TakesScreenshot srcShot=((TakesScreenshot)driver);
		File srcFile=srcShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(".//Screenshot//snap1.png"));
	}
	public void Dropdown() throws InterruptedException
	{
		WebElement dropdownlist=driver.findElement(Dropdownlist);
		Select s1=new Select(dropdownlist);
		Thread.sleep(3000);
		//S1.selectByValue("Price (high to low)");
		s1.selectByIndex(2);
	}
}
