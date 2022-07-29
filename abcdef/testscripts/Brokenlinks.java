package testscripts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Brokenlinks {
	WebDriver d;
	@Test
	public void fblogin() throws Exception
	{
		//load page  
		d.get("https://www.amazon.in/");
		//Alert al= d.switchTo().alert();
		//al.accept();
		List<WebElement> l=d.findElements(By.className("nav-a"));
		System.out.println("no of links:"+l.size());
		for(WebElement e:l)
		{
			try
			{
				if(e.getAttribute("href")!=null)
				{
					URL u=new URL(e.getAttribute("href"));
					//e.click();
					HttpURLConnection con=(HttpURLConnection)u.openConnection();
					con.setConnectTimeout(60000);
					con.connect();
					System.out.println("Response code:"+u+"--->"+con.getResponseCode() );
					if(con.getResponseCode()==200)
					{
						System.out.println("Link:"+u+"---->work");
					}
					else
					{
						System.out.println("Link:"+u+"--->not Work");
					}
				}
			}
			catch(Exception ie)
			{
		     	System.out.println("ie");
			}
			}
		
		
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
