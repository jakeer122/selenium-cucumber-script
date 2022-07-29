package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frame {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://jqueryui.com/autocomplete/#content");
		assertEquals(d.getTitle(),"Autocomplete | jQuery UI");
		//d.switchTo().frame(0);
		System.out.println("no of ifames:"+d.findElements(By.tagName("iframe")).size());
		d.switchTo().frame(0);
		d.findElement(By.id("tags")).sendKeys("Java");
		
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
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//close browser
		d.quit();
		
	}

}
