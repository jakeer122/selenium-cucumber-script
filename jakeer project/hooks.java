package Stepdef;

import config.Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	@Before
	public void beforeScenario()
	{
		System.out.println("=========");
		Common.launchBrowser();
	}
	@After
	public void afterScenario()
	{
		System.out.println("------------");
		Common.closeBrowser();
	}

}
