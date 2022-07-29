package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Navigation {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://www.amazon.in/");
		d.findElement(By.linkText("Best Sellers")).click();
		Thread.sleep(2000);
		d.findElement(By.linkText("Mobiles")).click();
		Thread.sleep(2000);
		d.navigate().back();
		Thread.sleep(2000);
		d.navigate().forward();
		Thread.sleep(2000);
		d.navigate().refresh();
		Thread.sleep(2000);
		
	}

	@BeforeMethod
	public void setup()
	{
		//load browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		d.manage().deleteAllCookies();
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//close browser
		d.quit();
		
	}

}
