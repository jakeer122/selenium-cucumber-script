package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames {

	public static void main(String[] args) throws Exception {
		//load browser
		WebDriver d=new FirefoxDriver();
		//load page
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		Thread.sleep(2000);
		d.switchTo().frame(0);
		//enter data
		d.findElement(By.id("w3loginbtn")).click();
		Thread.sleep(2000);
		d.quit();
	}

}
