package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegisterDemo {
	public static WebDriver d= new ChromeDriver();
	

	public static void main(String[] args) throws InterruptedException {
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		//launch browser
		d.get("https://nxtgenaiacademy.com/");
		//naviget to register demo
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.cssSelector("#menu-item-4131 > .menu-link"))).perform();
		Thread.sleep(2000);
		a.moveToElement(d.findElement(By.xpath("//li[3]/ul/li[3]/a"))).perform();
		Thread.sleep(3000);
		d.findElement(By.xpath("//li[3]/ul/li[3]/ul/li/a/span")).click();
		Thread.sleep(4000);
		d.findElement(By.xpath("//li[3]/div/span")).click();
		Thread.sleep(2000);
		//date
		d.findElement(By.id("vfb-18")).sendKeys("05/07/2022");
		//dd
		Select dd=new Select(d.findElement(By.id("vfb-16-hour")));
		dd.selectByIndex(8);
		Thread.sleep(2000);
		Select dd1=new Select(d.findElement(By.id("vfb-16-min")));
		dd1.selectByIndex(10);
		Thread.sleep(2000);
		d.findElement(By.id("vfb-20-0")).click();
		Thread.sleep(2000);
		//WebElement l=d.findElement(By.id("vfb-3"));
		//WebElement v=d.findElement(By.xpath("//fieldset[2]/ul/li/span/label"));
		//String val=v.getAttribute("Example");
		//String uname=d.findElement(By.xpath("//fieldset[2]/ul/li/span/label")).getAttribute("value");
		//System.out.println("value:"+uname);
		d.quit();
		
		
		
	}

}
