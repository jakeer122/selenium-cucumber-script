package project;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginImport {
	
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/ui/home");
		//read data from excel
		FileInputStream fis=new FileInputStream("D:\\selenium scripts\\textdata\\testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheet("Sheet1");
		for(int i=1;i<=s.getLastRowNum();i++)
		{
			// Click on Login link
			d.findElement(By.id("login-link")).click();
			// Enter user name
			d.findElement(By.xpath("//input[@type='text']")).clear();
			d.findElement(By.xpath("//input[@type='text']")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			String uname=d.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
			// Enter password
			d.findElement(By.xpath("//input[@type='password']")).clear();
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			String password=d.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
			// Click on Submit button
			d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
			Thread.sleep(2000);
			// Blank user name & blank password
			if(uname.equals("") && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector(".principal .invalid-feedback")).getText().contains("This field is required"));
				assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
			}
			// Blank user name and valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				assertTrue(d.findElement(By.cssSelector(".principal .invalid-feedback")).getText().contains("This field is required"));
			}
			// Blank password and valid/invalid user name
			else if(!(uname.equals("")) && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
			}
			// Valid user name and valid password
			else if(isElementPresent(d,By.id("logout-trigger")))
			{
				Thread.sleep(2000);
				d.findElement(By.id("logout-trigger")).click();
			}
			// Both user name and password are invalid/anyone is invalid
			else
			{
				assertTrue(d.findElement(By.cssSelector(".notification-message")).getText().contains("The given name / password are incorrect."));
				d.findElement(By.xpath("//span[contains(.,'×')]")).click();
			}
			

			Thread.sleep(3000);
		}
		
	}
	public boolean isElementPresent(WebDriver driver, By locator)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		try
		{
			driver.findElement(locator);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
			    
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
