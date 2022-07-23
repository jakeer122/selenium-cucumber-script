package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	public static String browser="FF";
	public static String url="https://demo.cyclos.org/ui/home";
	public static WebDriver d;
	
	public static void launchBrowser()
	{
		if(browser.equals("FF"))
		{
			d=new FirefoxDriver();
			
		}
		else if (browser.equals("GC"))
		{
			d=new ChromeDriver();
		}
		else if (browser.equals("EB"))
		{
			d=new EdgeDriver();
		}
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		d.manage().window().maximize();
	}
	public static void closeBrowser()
	{
		d.quit();
	}

}
