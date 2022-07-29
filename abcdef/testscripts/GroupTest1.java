package testscripts;

import org.testng.annotations.Test;

public class GroupTest1 {
	@Test(groups="g1")
	public void math1()
	{
		System.out.println("test from gt1");
	}
	@Test(groups="g1")
	public void math2()
	{
		System.out.println("test from gt2");
	}
	@Test(groups="g2")
	public void math3()
	{
		System.out.println("test from gt3");
	}
	@Test(groups="g3")
	public void math4()
	{
		System.out.println("test from gt4");
	}

}
