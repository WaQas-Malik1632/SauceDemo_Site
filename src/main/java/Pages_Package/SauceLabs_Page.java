package Pages_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SauceLabs_Page
{
	WebDriver driver;
//	By btn_contact_Sales=By.xpath("//a[@class='button is-rounded is-secondary']//span[contains(text(),'Contact sales')]");
	By btn_contact_Sales=By.xpath("//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div/div/div/div[1]/div/div[2]/ul/li[2]/a");
	
	By txt_firstname=By.id("FirstName");
	By txt_lastname=By.id("LastName");
	By txt_company=By.id("Company");
	By txt_Email=By.id("Email");
	By Dropdown_Comapanysize=By.id("Company_Size__c");
	By Dropdown_Country=By.id("Country");
	By int_phone=By.id("Phone");
	By Chk_Interest0=By.id("mktoCheckbox_30954_0");
	By Chk_Interest1=By.id("mktoCheckbox_30954_1");
	By Chk_Interest5=By.id("mktoCheckbox_30954_5");
	By txt_About_Desc=By.id("How_did_you_hear_about_Sauce_Labs__c");
	By txt_comment=By.id("Sales_Contact_Comments__c");
	
	By Chkbox_ConfirmPricayPolicy=By.id("mktoCheckbox_30959_0");
	

	public SauceLabs_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	public void pre_requiste()
	{
		WebElement btn_contact=driver.findElement(btn_contact_Sales);
		btn_contact.click();
	}
	public void Contact_SalesForm(String Fname, String Lname, String Comp, String email, String Phone, String Desc, String comment)
	{	
		WebElement F1=driver.findElement(txt_firstname);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		F1.sendKeys(Fname);
		
		WebElement L1=driver.findElement(txt_lastname);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		L1.sendKeys(Lname);
		
		WebElement com=driver.findElement(txt_company);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		com.sendKeys(Comp);
	
		WebElement em=driver.findElement(txt_Email);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		em.sendKeys(email);
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("window.scrollBy(0,500)");
		  
		  	WebElement dropdowncomp=driver.findElement(Dropdown_Comapanysize);
		  	Select Sel=new Select(dropdowncomp);
		  	Sel.selectByValue("51-100");
		
		  
			WebElement dropdowncuntry=driver.findElement(Dropdown_Country);
			Select Sel2=new Select(dropdowncuntry);
			Sel2.selectByValue("Austria");
		
		WebElement ph=driver.findElement(int_phone);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ph.sendKeys(Phone);
		
		WebElement value0=driver.findElement(Chk_Interest0);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		value0.click();
	
		WebElement chkboxvalue1=driver.findElement(Chk_Interest1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		chkboxvalue1.click();
		
		WebElement chkboxvalue5=driver.findElement(Chk_Interest5);	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		chkboxvalue5.click();
		
		
		WebElement Ab_desc=driver.findElement(txt_About_Desc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Ab_desc.sendKeys(Desc);
		
		WebElement commt=driver.findElement(txt_comment);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		commt.sendKeys(comment);
		
//		WebElement btnpolicy=driver.findElement(Chkbox_ConfirmPricayPolicy);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		btnpolicy.click();
//		btnpolicy.getText();
	}
	
}
