package testscripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {

	public static void main(String[] args) throws Exception {
		//load browser
		WebDriver d=new FirefoxDriver();
		//load page
		d.get("https://retail.onlinesbi.sbi/retail/login.htm");
		//click login
		d.findElement(By.className("login_button")).click();
		//Thread.sleep(2000);
		d.findElement(By.id("Button2")).click();
		Thread.sleep(2000);
		//alert
		Alert al=d.switchTo().alert();
		assertEquals(al.getText(),"Enter username");
		al.accept();
		d.findElement(By.id("username")).sendKeys("jakeer");
		d.findElement(By.id("Button2")).click();
		al.accept();
		d.findElement(By.id("label2")).sendKeys("jakeer");
		d.findElement(By.id("Button2")).click();
		al.accept();
		Thread.sleep(2000);
		d.findElement(By.linkText("New User ? Register here/Activate")).click();
		Thread.sleep(2000);
		d.switchTo().alert().dismiss();
		Thread.sleep(2000);
		d.quit();
	}

}
