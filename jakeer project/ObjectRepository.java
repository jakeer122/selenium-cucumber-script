package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {
	
	@FindBy(id="login-link") public WebElement linklogin;
	@FindBy(xpath="//input[@type='text']") public WebElement tfusername;
	@FindBy(xpath="//input[@type='password']") public WebElement tfpassword;
	@FindBy(xpath="//button[contains(.,'Submit')]") public WebElement buttonsubmit;
	@FindBy(id="logout-trigger") public WebElement btnlogout;
	
	public ObjectRepository(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	
	public void filldetails(String uname,String pass)
	{
		//linklogin.click();
		tfusername.sendKeys(uname);
		tfpassword.sendKeys(pass);
		buttonsubmit.click();
	}

}
