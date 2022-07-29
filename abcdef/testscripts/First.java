package testscripts;

public class First {
	int a,b;
	First (int i,int j)
	{
		//System.out.println("sum:+(a+b)");
		a=i;
		b=j;
	}

	public static void main(String[] args) {
		First fir=new First(10,10);
		System.out.println("sum:"+(fir.a+fir.b));
		

	}

}
