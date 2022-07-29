package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webdriver {

	public static void main(String[] args) throws Exception {
		// Launch browser
		//System.setProperty("webdriver.gecko.driver", "D:\\selenium scripts\\drivers\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\selenium scripts\\drivers\\chromedriver.exe");
		//WebDriver d=new ChromeDriver();
		//System.setProperty("webdriver.edge.driver", "D:\\selenium scripts\\drivers\\msedgedriver.exe");
		//WebDriver d=new EdgeDriver();
		// Load web page
		d.get("https://www.facebook.com/");
		// Pause 3sec
		Thread.sleep(3000);
		// Close the browser
		d.quit();

	}

}