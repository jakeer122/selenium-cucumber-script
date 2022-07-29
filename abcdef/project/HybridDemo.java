package project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;
import pages.ObjectRepository;

public class HybridDemo {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get(Common.url);
		ObjectRepository login=new ObjectRepository(d);
       
		login.filldetails("demo", "1234");
		Thread.sleep(2000);
		//click logout
		login.btnlogout.click();
		Thread.sleep(2000);
		
	}


}
