package testscripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browserslider {
	WebDriver d;
	@Test
	public void testBrowserSlider() throws Exception
	{
		//Load web page
		d.get("https://jqueryui.com/");
	
		while(isElementPresent(d,By.linkText("slider")))
		{
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,400)");
			Thread.sleep(1000);
		}
			
		/*for(int i=0;i<5;i++)
		{
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,400)");
			Thread.sleep(1000);
		}*/
		// ((RemoteWebDriver) d).executeScript("window.scrollTo(0,0)");
		Thread.sleep(5000);
				
	}

	public boolean isElementPresent(WebDriver driver, By locator)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		try
		{
			driver.findElement(locator);
			return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
			    
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		//d =new ChromeDriver();
		//Maximize browser
		d.manage().window().maximize();
		//d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}


}


