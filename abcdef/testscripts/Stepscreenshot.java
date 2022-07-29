package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Stepscreenshot {
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
	    d.findElement(By.linkText("Droppable")).click();
	    Thread.sleep(2000);
	    d.switchTo().frame(0);
	    Actions a=new Actions(d);
	    a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).perform();
	    Thread.sleep(2000);
	    d.findElement(By.linkText("Slider")).click();
	    d.switchTo().frame(0);
	    a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")), 300, 0);
	    Thread.sleep(2000);
	    
	    
	    
	    
	    //mouse move over
	    /*Actions a=new Actions(d);
	    a.moveToElement(d.findElement(By.linkText("Contribute"))).perform();
	    Thread.sleep(2000);
	    d.findElement(By.linkText("Bug Triage")).click();
	    Thread.sleep(2000);*/
	    
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
