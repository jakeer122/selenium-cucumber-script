package project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ObjectRepository;

public class PageFactory {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/ui/home");
		ObjectRepository login=new ObjectRepository(d);
		login.filldetails("demo", "1234");
		//click login
		/*login.linklogin.click();
		//enter username
		login.tfusername.sendKeys("demo");
		//enter password
		login.tfpassword.sendKeys("1234");
		//clik submit
		login.buttonsubmit.click();*/
		Thread.sleep(2000);
		//click logout
		login.btnlogout.click();
		Thread.sleep(2000);
		
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
