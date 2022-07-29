package testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Keyboard {
	WebDriver d;
	@Test
	public void testBrowserSlider() throws Exception
	{
		//Load web page
		d.get("https://jqueryui.com/");
		d.findElement(By.linkText("Autocomplete")).click();
		Thread.sleep(2000);
		d.switchTo().frame(0);
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("no of sujjtion:"+s.size());
		for(WebElement e:s)
		{
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			if (e.getText().equals("Asp"))
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				break;
				
			}
			Thread.sleep(2000);
			
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
