package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
	public WebDriver d;
	public static String url=("https://demo.cyclos.org/ui/home");
	@Parameters("browser")
	
	
	@BeforeMethod
	public void setup(String browser)
	{
	if(browser.equals("FF"))
	{
		d=new FirefoxDriver();
	}
	else if(browser.equals("GC"))
	{
		d= new ChromeDriver();
	}
	else if (browser.equals("EB"))
	{
		d=new EdgeDriver();
	}
		
	
		//load browser
		//d=new FirefoxDriver();
		//d= new ChromeDriver();
			
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//close browser
		d.quit();
		
	}

}
