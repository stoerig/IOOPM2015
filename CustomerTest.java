//kurwa
public class CustomerTest {

	public static void main(String args[])
	{
		Customer c = new Customer(0,3);
		c.serve();
		c.serve();
		
		int x = c.getGroceries();
		
		System.out.println(x);
		System.out.println(c.isDone());
		c.serve();
		System.out.println(x);
		System.out.println(c.isDone());
	}
	
	
}
