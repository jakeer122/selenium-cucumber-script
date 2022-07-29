
package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class Testngfb extends Common  {
	WebDriver d;
	@Test
	public void fblogin()
	{
		//load page  
		d.get("https://www.facebook.com/");
		//print title
		System.out.println("title:"+d.getTitle());
		//verify title
	    assertEquals(d.getTitle(),"Facebook – log in or sign up");
		//enter user nam
	    assertTrue(d.findElement(By.id("email")).isDisplayed());
		d.findElement(By.id("email")).sendKeys("selenium");
		//gettes
		System.out.println("username:"+d.findElement(By.id("email")).getAttribute("value"));
		//enter password
		d.findElement(By.id("pass")).sendKeys("jakeer");
		//click login
		d.findElement(By.name("login")).click();
	}
	



	@BeforeMethod
	public void setup()
	{
		//load browser
		d=new FirefoxDriver();
	}
	
	@AfterMethod
	public void teardown()
	{
		//close browser
		d.quit();
		
	}




}