package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class WindowHandle extends Common {

	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://retail.onlinesbi.sbi/retail/login.htm");
		System.out.println("title:"+d.getTitle());
		assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
		d.findElement(By.xpath("//img[@src='/sbijava/retail/images/HomeLoanButton.png']")).click();
		Thread.sleep(3000);
		System.out.println("no of winds:"+d.getWindowHandles().size());
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(al.get(1));
		Thread.sleep(2000);
		
		assertTrue(d.findElement(By.linkText("Login")).isDisplayed());
		d.close();
		d.switchTo().window(al.get(0));
		Thread.sleep(2000);
		assertTrue(d.findElement(By.linkText("CONTINUE TO LOGIN")).isDisplayed());
		Thread.sleep(2000);
		
		
	}


}
