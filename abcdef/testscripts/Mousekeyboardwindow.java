package testscripts;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mousekeyboardwindow {
	WebDriver d;
	@Test
	public void testBrowserSlider() throws Exception
	{
		//Load web page
		d.get("https://www.google.com/");
		WebElement link=d.findElement(By.linkText("Gmail"));
		Actions al=new Actions(d);
		al.moveToElement(link).keyDown(Keys.CONTROL).click(link).build().perform();
		ArrayList<String> a=new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(a.get(1));
		Thread.sleep(2000);
		d.switchTo().window(a.get(0));
		Thread.sleep(2000);
		
		
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
