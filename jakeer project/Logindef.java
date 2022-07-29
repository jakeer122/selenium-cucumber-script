package Stepdef;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.Common;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ObjectRepository;

public class Logindef extends Common {
	
	ObjectRepository loginPage;
	
	@Given("if user is on home page")
	public void if_user_is_on_home_page() {
		// Launch the browser
		//launchBrowser();

		// Load web page
		d.get(url);
		loginPage=new ObjectRepository(d);
	}

	@When("click on login link")
	public void click_on_login_link() {

		// Click on Login link
		//d.findElement(By.id("login-link")).click();
		loginPage.linklogin.click();
	}

	@When("enter login details")
	public void enter_login_details() {
		//d.findElement(By.xpath("//input[@type='text']")).sendKeys("demo");
		//d.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
		//d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
	}
	
	@When("enter login details username as {string} and password as {string}")
	public void enter_login_details_username_as_and_password_as(String uname, String password) {
		loginPage.filldetails(uname, password);
		//d.findElement(By.xpath("//input[@type='text']")).sendKeys(uname);
		//d.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		//d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
	}

	

	@Then("verify logout link")
	public void verify_logout_link() {
		assertTrue(loginPage.btnlogout.isDisplayed());
		//close browser 
		//closeBrowser();
	}
	@When("click pay user link")
	public void click_pay_user_link() throws InterruptedException {
		d.findElement(By.xpath("//a/div[2]")).click();
		Thread.sleep(2000);

	}

	@Then("verify payment to user page")
	public void verify_payment_to_user_page() throws InterruptedException {
		assertTrue(d.findElement(By.xpath("//button/span")).isDisplayed());
		Thread.sleep(2000);
		//closeBrowser();

	}

}
