package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://retail.onlinesbi.sbi/retail/login.htm");
		System.out.println("title:"+d.getTitle());
		assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
		d.findElement(By.xpath("//img[@src='/sbijava/retail/images/HomeLoanButton.png']")).click();
		Thread.sleep(2000);
		DateFormat sdf=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		Date dt=new Date();
		
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotFile, new File("D:\\selenium scripts\\abcdef\\Screenshot\\page.png"));
		FileUtils.copyFile(screenshotFile, new File("D:\\selenium scripts\\abcdef\\Screenshot\\"+sdf.format(dt)+".png"));
		
	}
	@BeforeMethod
	public void setup()
	{
		//load browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//close browser
		d.quit();
		
	}

}
