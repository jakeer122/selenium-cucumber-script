package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FailScreenshot {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		assertEquals(getScreenshot(),"pass");
		
	    Thread.sleep(2000);
	}
	public String getScreenshot() throws Exception
	{
		try
		{
			//load page  
			d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
			//print title
			System.out.println("title:"+d.getTitle());
			//verify title
		    assertEquals(d.getTitle(),"Bank IFSC Codes: Find IFSC for Major Banks in India");
		    Select bank=new Select(d.findElement(By.id("selBank")));
		    bank.selectByVisibleText("Andhra Bank");
		    Select state=new Select(d.findElement(By.id("selState")));
		    state.selectByVisibleText("Andhra Pradesh");
		    Select city=new Select(d.findElement(By.id("selCity")));
		    city.selectByVisibleText("Adoni");
		    Select branch=new Select(d.findElement(By.id("selBranch")));
		    branch.selectByVisibleText("Adoni");
		    return "pass";
		}
		catch(Exception e)
		{
			DateFormat sdf=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
			Date dt=new Date();
			
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshotFile, new File("D:\\selenium scripts\\abcdef\\Screenshot\\page.png"));
			FileUtils.copyFile(screenshotFile, new File("D:\\selenium scripts\\abcdef\\Screenshot\\"+sdf.format(dt)+".png"));
			return "fail";
			
		}
	}
	
	@BeforeMethod
	public void setup()
	{
		//load browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//close browser
		d.quit();
		
	}


}
