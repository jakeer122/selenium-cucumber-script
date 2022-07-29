package testscripts;

import org.testng.annotations.Test;

public class Dependency {
	
	@Test
	public void meth1()
	{
		System.out.println("meth1");
		int x=20/2;
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("meth2");
		String x = null;
		System.out.println("print:"+x);
		
	}

}
