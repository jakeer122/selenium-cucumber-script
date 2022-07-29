import org.testng.annotations.Test;

public class Priyority {
	
	@Test(priority=2)
	public void math1()
	{
		System.out.println("test from gt1");
	}
	@Test(priority=4)
	public void math2()
	{
		System.out.println("test from gt2");
	}
	@Test(priority=1)
	public void math3()
	{
		System.out.println("test from gt3");
	}
	@Test(priority=3)
	public void math4()
	{
		System.out.println("test from gt4");
	}
	

}
