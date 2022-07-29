package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocateElements {

	public static void main(String[] args) throws Exception {
		// Launch the browser
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.facebook.com/");
		//ID
		d.findElement(By.id("email")).sendKeys("Selenium");
		//Name
		d.findElement(By.name("pass")).sendKeys("Appium");
		// Link Text
		d.findElement(By.linkText("Forgotten password?")).click();
		// Partial link text
		d.findElement(By.partialLinkText("password")).click();
		// XPath
		d.findElement(By.xpath("//input[@id='email']")).sendKeys("Selenium");
		// TagName
		System.out.println("No of links:"+d.findElements(By.tagName("a")).size());
		System.out.println("No of iframes:"+d.findElements(By.tagName("iframe")).size());
		//css selector
		d.findElement(By.cssSelector(".\\_8esh")).click();
		// Pause 3 sec
		Thread.sleep(3000);
		// Close the browser
		d.quit();

	}

}