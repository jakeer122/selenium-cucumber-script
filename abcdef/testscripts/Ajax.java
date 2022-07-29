package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ajax {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
		//print title
		System.out.println("title:"+d.getTitle());
		//verify title
	    assertEquals(d.getTitle(),"Bank IFSC Codes: Find IFSC for Major Banks in India");
	    Select bank=new Select(d.findElement(By.id("selBank")));
	    bank.selectByVisibleText("Andhra Bank");
	    Select state=new Select(d.findElement(By.id("selState")));
	    state.selectByVisibleText("Andhra Pradesh");
	    Select city=new Select(d.findElement(By.id("selCity")));
	    city.selectByVisibleText("Adoni");
	    Select branch=new Select(d.findElement(By.id("selBranch")));
	    branch.selectByVisibleText("Adoni");
	    Thread.sleep(2000);
	    
	    
	    
	    
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
