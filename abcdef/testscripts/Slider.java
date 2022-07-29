package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Slider {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://jquery.com/");
		//print title
		System.out.println("title:"+d.getTitle());
		//verify title
	    assertEquals(d.getTitle(),"jQuery");
	    d.findElement(By.linkText("jQuery UI")).click();
	    Thread.sleep(2000);
	    while(isElementPresent(d, By.linkText("Slider")))
	    {
	    	((RemoteWebDriver) d).executeScript("window.scrollBy(0,400)");
	    	Thread.sleep(5000);}
	    }
	    public boolean isElementPresent(WebDriver driver, By webElement)
	    {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    try
	    {
	    	driver.findElement(webElement);
	    	return false;
	    }
	    catch(NoSuchElementException e)
	    {
	    	return true;
	    }
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