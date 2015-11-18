public class Customer 
{
	int bornTime;
	int groceries;
	
	public Customer(int init_bornTime, int init_groceries)
	{
		bornTime = init_bornTime;
		groceries = init_groceries;
	}
	
	public void setGroceries(int new_groceries){
		groceries = new_groceries;
	}
	
	public int getGroceries(){
		return groceries;
	}
	
	public void serve()
	{
		if (groceries > 0)
		{
			groceries--;	
		}
		else
		{
			System.out.println("Done customer sent to serve");
		}
	}
	
	public boolean isDone()
	{
		if(groceries == 0)
		{
			return true;
		}
			return false;
	}
	
}
