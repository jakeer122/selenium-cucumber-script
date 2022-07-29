package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Fbloginn {

	public static void main(String[] args) throws InterruptedException {
		//load browser
		WebDriver d=new FirefoxDriver();
		//load page
		d.get("https://www.facebook.com/");
		//enter user name
		d.findElement(By.id("email")).sendKeys("selenium");
		//gettest
		System.out.println("username:"+d.findElement(By.id("email")).getAttribute("value"));
		//enter password
		d.findElement(By.id("pass")).sendKeys("jakeer");
		//click login
		d.findElement(By.name("login")).click();
		Thread.sleep(2000);
		d.quit();
		
	}

}
