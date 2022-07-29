package testscripts;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Fblogin {

	public static void main(String[] args) throws Exception {
		//launch browser
		WebDriver d= new ChromeDriver();
		//load web page
	    d.get("https://www.facebook.com/");
	    //enter user name
	    //d.findElement(By.id("email")).sendKeys("jakeer");
	    //enter password
	    //d.findElement(By.id("pass")).sendKeys("jakeer");
	    //click login
	    //d.findElement(By.name("login")).click();
	    d.findElement(By.linkText("Create New Account")).click();
	    Thread.sleep(2000);
	    Select dd=new Select(d.findElement(By.id("day")));
	    dd.selectByIndex(5);
	    Thread.sleep(2000);
	    Select ddd=new Select(d.findElement(By.id("month")));
	    ddd.selectByValue("3");
	    Thread.sleep(2000);
	    Select dddd=new Select(d.findElement(By.id("year")));
	    dddd.selectByIndex(2);
	    assertFalse(d.findElement(By.name("sex")).isSelected());
	    
	    Thread.sleep(3000);
	    d.quit();
	    
		

	}

}
