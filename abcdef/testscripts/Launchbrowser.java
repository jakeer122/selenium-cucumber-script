package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launchbrowser {

	public static void main(String[] args) throws InterruptedException {
		//launch browser
		WebDriver d=new FirefoxDriver();
		d.get("https://www.facebook.com/");
		Thread.sleep(2000);
		d.quit();

	}

}
