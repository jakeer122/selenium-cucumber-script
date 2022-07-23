package Stepdef;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fbloginm {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://www.facebook.com/");
		//print title
		System.out.println("title:"+d.getTitle());
		//verify title
	    assertEquals(d.getTitle(),"Facebook – log in or sign up");
	    Thread.sleep(2000);
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
