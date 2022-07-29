package project;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login1 {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/ui/home");
		Thread.sleep(2000);
		d.findElement(By.id("login-link")).click();
		Thread.sleep(0);
		d.findElement(By.cssSelector("input[placeholder='User']")).clear();
		d.findElement(By.cssSelector("input[placeholder='User']")).sendKeys("demo");
		String uname=d.findElement(By.cssSelector("input[placeholder='User']")).getAttribute("value");
		Thread.sleep(2000);
		d.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		d.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("1234");
		String pass=d.findElement(By.cssSelector("input[placeholder='Password']")).getAttribute("value");
		Thread.sleep(2000);
		d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		Thread.sleep(3000);
		if(uname.equals("") && pass.equals(""))
		{
			assertTrue(d.findElement(By.className("invalid-feedback")).getText().contains("This field is required"));
			assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
		}
		//user name blank
		else if(uname.equals("") && !(pass.equals("")))
		{
			assertTrue(d.findElement(By.className("invalid-feedback")).getText().contains("This field is required"));
		}
		//password blank
		else if(!(uname.equals("")) && pass.equals(""))
		{
			assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
		}
		//d.findElement(By.cssSelector("#logout-trigger .ci")).click();
		Thread.sleep(2000);
		// Valid user name and valid password
		 if(isElementPresent(d,By.id("logout-trigger")))
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
